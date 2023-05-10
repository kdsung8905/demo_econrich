package com.example.econrich.domain.employee;

import com.example.econrich.dto.employee.EmployeeReqDto;
import com.example.econrich.dto.employee.EmployeeResDto;
import com.example.econrich.dto.employee.QEmployeeResDto_JobHistoryResDto;
import com.example.econrich.dto.employee.QEmployeeResDto_ProfileResDto;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.DatePath;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.econrich.domain.Location.QLocation.location;
import static com.example.econrich.domain.country.QCountry.country;
import static com.example.econrich.domain.department.QDepartment.department;
import static com.example.econrich.domain.employee.QEmployee.employee;
import static com.example.econrich.domain.job.QJob.job;
import static com.example.econrich.domain.jobhistory.QJobHistory.jobHistory;
import static com.example.econrich.domain.region.QRegion.region;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;

    public Optional<EmployeeResDto.ProfileResDto> findProfile(Long id){

        return Optional.ofNullable(jpaQueryFactory
                .select(new QEmployeeResDto_ProfileResDto(
                        employee.employeeId,
                        employee.firstName,
                        employee.lastName,
                        employee.email,
                        employee.phoneNumber,
                        convertDate(employee.hireDate),
                        employee.salary,
                        employee.commissionPct,
                        department.departmentName,
                        location.streetAddress,
                        location.postalCode,
                        location.city,
                        country.countryName,
                        region.regionName
                ))
                .from(employee)
                .leftJoin(employee.department, department)
                .leftJoin(department.location, location)
                .leftJoin(location.country, country)
                .leftJoin(country.region, region)
                .where(employee.employeeId.eq(id))
                .fetchOne());
    }

    public List<EmployeeResDto.JobHistoryResDto> findHistory(Long id){

        return jpaQueryFactory
                .select(new QEmployeeResDto_JobHistoryResDto(
                        employee.employeeId,
                        convertDate(jobHistory.startDate),
                        convertDate(jobHistory.endDate),
                        job.jobTitle,
                        job.minSalary,
                        job.maxSalary
                ))
                .from(jobHistory)
                .innerJoin(jobHistory.employee, employee)
                .leftJoin(jobHistory.job, job)
                .where(employee.employeeId.eq(id))
                .fetch();
    }

    @Transactional
    public void updateSalary(EmployeeReqDto.IncreaseSalaryDto dto){

        BigDecimal percentageIncrease = dto.getPayIncreaseRate().divide(new BigDecimal("100")).add(new BigDecimal("1"));

        long cnt = jpaQueryFactory
                .update(employee)
                .set(employee.salary, employee.salary.multiply(percentageIncrease))
                .where(employee.job.jobId.eq(dto.getJobId()))
                .execute();

        entityManager.flush();
        entityManager.clear();
    }

    private StringTemplate convertDate(DatePath<LocalDate> hireDate){
        return Expressions.stringTemplate(
                "DATE_FORMAT({0},{1})",
                hireDate,
                ConstantImpl.create("%Y-%m-%d")
        );
    }
}
