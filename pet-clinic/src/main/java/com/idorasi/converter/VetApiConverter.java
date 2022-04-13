package com.idorasi.converter;

import com.idorasi.dto.VetApi;
import com.idorasi.dto.VetCreateApi;
import com.idorasi.model.Vet;
import jakarta.inject.Singleton;

@Singleton
public class VetApiConverter {

    public VetApi convertFromEntity(Vet vet) {
        return VetApi.builder()
                .firstName(vet.getFirstName())
                .lastName(vet.getLastName())
                .speciality(vet.getSpeciality())
                .build();
    }

    public Vet convertToEntity(VetCreateApi vetCreateApi) {
        return Vet.builder()
                .firstName(vetCreateApi.getFirstName())
                .lastName(vetCreateApi.getLastName())
                .speciality(vetCreateApi.getSpeciality())
                .build();
    }
}
