package com.example.econrich.domain.region;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "regions")
@Entity
@Getter
@NoArgsConstructor
public class Region {

    @Id
    private Long regionId;

    private String regionName;
}
