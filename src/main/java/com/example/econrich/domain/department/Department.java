package com.example.econrich.domain.department;

import com.example.econrich.domain.Location.Location;
import com.example.econrich.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "departments")
@Entity
@Getter
@NoArgsConstructor
public class Department {

    @Id
    private Long departmentId;

    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
