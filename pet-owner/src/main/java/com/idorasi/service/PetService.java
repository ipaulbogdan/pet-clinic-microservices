package com.idorasi.service;

import com.idorasi.converter.PetApiConverter;
import com.idorasi.dto.pet.PetApi;
import com.idorasi.model.repository.PetRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
public class PetService {

    private PetRepository petRepository;

    @Transactional
    public List<PetApi> retrieveAllPets() {
        return petRepository.findAll().stream()
                .map(PetApiConverter::convertFromEntity)
                .collect(Collectors.toList());
    }
}
