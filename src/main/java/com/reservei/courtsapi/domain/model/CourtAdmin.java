package com.reservei.courtsapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourtAdmin {

    private Long id;

    private String publicId;

    private String name;

    private String email;

    private String cpfCnpj;
}
