package com.reservei.courtsapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourtAddress {

    private String street;

    private String district;

    private String zipCode;

    private String city;

    private String state;

    private String country;

    private String latitude;

    private String longitude;
}
