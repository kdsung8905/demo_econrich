package com.example.econrich.domain.jobhistory;

import com.example.econrich.domain.department.Department;
import com.example.econrich.domain.employee.Employee;
import com.example.econrich.domain.job.Job;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "job_history")
@Entity
@Getter
@NoArgsConstructor
public class JobHistory {

    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
