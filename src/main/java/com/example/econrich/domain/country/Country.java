package com.example.econrich.domain.country;

import com.example.econrich.domain.region.Region;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "countries")
@Entity
@Getter
@NoArgsConstructor
public class Country {

    @Id
    private String countryId;

    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
