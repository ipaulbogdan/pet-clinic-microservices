package com.idorasi.converter;

import com.idorasi.dto.owner.OwnerApi;
import com.idorasi.dto.owner.OwnerCreateApi;
import com.idorasi.model.Owner;

import java.util.UUID;

public class OwnerApiConverter {

    public static OwnerApi convertFromEntity(Owner owner) {
        return OwnerApi.builder()
                .publicIdentifier(owner.getPublicIdentifier())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .address(owner.getAddress())
                .city(owner.getCity())
                .telephone(owner.getTelephone())
                .build();
    }

    public static Owner convertToEntity(OwnerCreateApi ownerCreateApi) {
        return Owner.builder()
                .firstName(ownerCreateApi.getFirstName())
                .lastName(ownerCreateApi.getLastName())
                .publicIdentifier(UUID.randomUUID())
                .address(ownerCreateApi.getAddress())
                .city(ownerCreateApi.getCity())
                .telephone(ownerCreateApi.getTelephone())
                .build();
    }
}
