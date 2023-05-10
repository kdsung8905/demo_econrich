package com.example.econrich.domain.job;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "jobs")
@Entity
@Getter
@NoArgsConstructor
public class Job {

    @Id
    private String jobId;

    private String jobTitle;

    private BigDecimal minSalary;

    private BigDecimal maxSalary;
}
