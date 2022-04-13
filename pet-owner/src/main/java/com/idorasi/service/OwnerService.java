package com.idorasi.service;

import com.idorasi.converter.OwnerApiConverter;
import com.idorasi.dto.owner.OwnerApi;
import com.idorasi.dto.owner.OwnerCreateApi;
import com.idorasi.model.repository.OwnerRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
public class OwnerService {

    private OwnerRepository ownerRepository;

    public List<OwnerApi> retrieveAllOwners() {
        return ownerRepository.findAll().stream()
                .map(OwnerApiConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public OwnerApi saveOwner(OwnerCreateApi ownerCreateApi) {
        //probably some validation required, but will skip that for now
        var owner = OwnerApiConverter.convertToEntity(ownerCreateApi);

        return OwnerApiConverter.convertFromEntity(ownerRepository.save(owner));
    }

    public void deleteOwner(UUID publicIdentifier) {
        var owner = ownerRepository.findByPublicIdentifier(publicIdentifier)
                .orElseThrow(EntityNotFoundException::new);

        ownerRepository.delete(owner);
    }
}
