package com.example.econrich.config.dummy;

import com.example.econrich.domain.employee.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DummyObject {

    protected  Employee newMockEmployee(Long employeeId, String firstName, String lastName){
        return Employee.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .email("NKOCHHAR")
                .phoneNumber("515.123.4568")
                .hireDate(LocalDate.parse("1989-09-21", DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .salary(new BigDecimal("17000.00"))
                .commissionPct(null)
                .build();

    }
}
