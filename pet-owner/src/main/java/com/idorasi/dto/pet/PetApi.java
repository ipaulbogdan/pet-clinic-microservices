package com.idorasi.dto.pet;

import com.idorasi.dto.owner.OwnerApi;
import com.idorasi.model.enums.Type;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PetApi {

    private UUID publicIdentifier;
    private String name;
    private LocalDate birthDate;
    private OwnerApi ownerApi;
    private Type type;

}
