package com.idorasi.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VetCreateApi {

    private String firstName;
    private String lastName;
    private String speciality;
}
