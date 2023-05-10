package com.example.econrich.dto.employee;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;


public class EmployeeResDto {

    @Getter
    @Setter
    @ToString
    public static class ProfileResDto{

        @Schema(description = "employeeId(pk)", example = "101")
        private Long employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private String hireDate;
        private BigDecimal salary;
        private BigDecimal commissionPct;
        private String departmentName;
        private String streetAddress;
        private String postalCode;
        private String city;
        private String countryName;
        private String regionName;

        @QueryProjection
        public ProfileResDto(Long employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, BigDecimal salary, BigDecimal commissionPct, String departmentName, String streetAddress, String postalCode, String city, String countryName, String regionName) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.hireDate = hireDate;
            this.salary = salary;
            this.commissionPct = commissionPct;
            this.departmentName = departmentName;
            this.streetAddress = streetAddress;
            this.postalCode = postalCode;
            this.city = city;
            this.countryName = countryName;
            this.regionName = regionName;
        }
    }


    @Getter
    @Setter
    @ToString
    public static class JobHistoryResDto{

        private Long employeeId;
        private String startDate;
        private String endDate;
        private String jobTitle;
        private BigDecimal minSalary;
        private BigDecimal maxSalary;

        @QueryProjection

        public JobHistoryResDto(Long employeeId, String startDate, String endDate, String jobTitle, BigDecimal minSalary, BigDecimal maxSalary) {
            this.employeeId = employeeId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.jobTitle = jobTitle;
            this.minSalary = minSalary;
            this.maxSalary = maxSalary;
        }
    }
}
