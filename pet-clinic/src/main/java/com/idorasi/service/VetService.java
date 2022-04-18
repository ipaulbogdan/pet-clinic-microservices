package com.idorasi.service;

import com.idorasi.converter.VetApiConverter;
import com.idorasi.dto.VetApi;
import com.idorasi.dto.VetCreateApi;
import com.idorasi.dto.VetReviewApi;
import com.idorasi.model.repository.VetRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
@Slf4j
public class VetService {

    private VetRepository vetRepository;
    private VetApiConverter vetApiConverter;

    public List<VetApi> findAllVets() {
        return vetRepository.findAll().stream()
                .map(vetApiConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public VetApi createVet(VetCreateApi vetCreateApi) {
        validateVetCreateApi(vetCreateApi);
        var vet = vetApiConverter.convertToEntity(vetCreateApi);

        return vetApiConverter.convertFromEntity(vetRepository.save(vet));
    }

    public void deleteVet(String lastName) {
        var vet = vetRepository.findByLastName(lastName)
                .orElseThrow(() -> new IllegalArgumentException("Unable to find vet with last name: " + lastName));

        vetRepository.delete(vet);
    }

    public void processVetReview(VetReviewApi vetReviewApi) {
      var vet = vetRepository.findById(vetReviewApi.getVetId())
              .orElseThrow(() -> new IllegalArgumentException(String.format("Unable to find Vet with id %s", vetReviewApi.getVetId())));

      var vetRating = vet.getRating() == null ? vetReviewApi.getRating() : (vet.getRating() + vetReviewApi.getRating()) / 2;

      vet.setRating(vetRating);
      vetRepository.update(vet);
    }

    private void validateVetCreateApi(VetCreateApi vetCreateApi) {
        vetRepository.findByLastName(vetCreateApi.getLastName()).ifPresent((vet) -> {
            throw new IllegalArgumentException("Vet last name must be unique");
        });
    }
}
