package com.example.econrich.domain.Location;

import com.example.econrich.domain.country.Country;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "locations")
@Entity
@Getter
@NoArgsConstructor
public class Location {

    @Id
    private Long locationId;

    private String streetAddress;

    private String postalCode;

    private String city;

    private String stateProvince;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


}
