package com.idorasi.dto.visit;

import com.idorasi.dto.pet.PetApi;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VisitApi {

    private UUID publicIdentifier;
    private LocalDate visitDate;
    private String description;
    private PetApi petApi;

}
