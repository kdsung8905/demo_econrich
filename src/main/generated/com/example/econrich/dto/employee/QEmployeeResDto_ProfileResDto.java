package com.example.econrich.dto.employee;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.econrich.dto.employee.QEmployeeResDto_ProfileResDto is a Querydsl Projection type for ProfileResDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QEmployeeResDto_ProfileResDto extends ConstructorExpression<EmployeeResDto.ProfileResDto> {

    private static final long serialVersionUID = -976685804L;

    public QEmployeeResDto_ProfileResDto(com.querydsl.core.types.Expression<Long> employeeId, com.querydsl.core.types.Expression<String> firstName, com.querydsl.core.types.Expression<String> lastName, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<String> phoneNumber, com.querydsl.core.types.Expression<String> hireDate, com.querydsl.core.types.Expression<? extends java.math.BigDecimal> salary, com.querydsl.core.types.Expression<? extends java.math.BigDecimal> commissionPct, com.querydsl.core.types.Expression<String> departmentName, com.querydsl.core.types.Expression<String> streetAddress, com.querydsl.core.types.Expression<String> postalCode, com.querydsl.core.types.Expression<String> city, com.querydsl.core.types.Expression<String> countryName, com.querydsl.core.types.Expression<String> regionName) {
        super(EmployeeResDto.ProfileResDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, java.math.BigDecimal.class, java.math.BigDecimal.class, String.class, String.class, String.class, String.class, String.class, String.class}, employeeId, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPct, departmentName, streetAddress, postalCode, city, countryName, regionName);
    }

}

