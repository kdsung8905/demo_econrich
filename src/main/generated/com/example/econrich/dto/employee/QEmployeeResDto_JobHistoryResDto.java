package com.example.econrich.dto.employee;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.econrich.dto.employee.QEmployeeResDto_JobHistoryResDto is a Querydsl Projection type for JobHistoryResDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QEmployeeResDto_JobHistoryResDto extends ConstructorExpression<EmployeeResDto.JobHistoryResDto> {

    private static final long serialVersionUID = 2067507626L;

    public QEmployeeResDto_JobHistoryResDto(com.querydsl.core.types.Expression<Long> employeeId, com.querydsl.core.types.Expression<String> startDate, com.querydsl.core.types.Expression<String> endDate, com.querydsl.core.types.Expression<String> jobTitle, com.querydsl.core.types.Expression<? extends java.math.BigDecimal> minSalary, com.querydsl.core.types.Expression<? extends java.math.BigDecimal> maxSalary) {
        super(EmployeeResDto.JobHistoryResDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, java.math.BigDecimal.class, java.math.BigDecimal.class}, employeeId, startDate, endDate, jobTitle, minSalary, maxSalary);
    }

}

