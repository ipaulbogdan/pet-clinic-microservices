package com.idorasi.dto.owner;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OwnerApi {

    private UUID publicIdentifier;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
}
