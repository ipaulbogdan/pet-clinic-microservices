package com.idorasi.dto.owner;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OwnerUpdateApi {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;
}
