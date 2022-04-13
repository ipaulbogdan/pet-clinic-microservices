package com.idorasi.converter;

import com.idorasi.dto.pet.PetApi;
import com.idorasi.model.Pet;

public class PetApiConverter {

    public static PetApi convertFromEntity(Pet pet) {
        return PetApi.builder()
                .publicIdentifier(pet.getPublicIdentifier())
                .name(pet.getName())
                .birthDate(pet.getBirthDate())
                .ownerApi(OwnerApiConverter.convertFromEntity(pet.getOwner()))
                .type(pet.getType())
                .build();
    }
}
