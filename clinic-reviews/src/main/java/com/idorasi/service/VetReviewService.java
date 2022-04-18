package com.idorasi.service;

import com.idorasi.client.VetReviewClient;
import com.idorasi.converter.VetReviewApiConverter;
import com.idorasi.dto.VetReviewApi;
import com.idorasi.dto.VetReviewApiCreator;
import com.idorasi.model.repository.VetReviewRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
public class VetReviewService {

    private VetReviewRepository vetReviewRepository;
    private VetReviewApiConverter vetReviewApiConverter;
    private VetReviewClient vetReviewClient;

    public List<VetReviewApi> retrieveAllReviews() {
        return vetReviewRepository.findAll().stream()
                .map(vetReviewApiConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public VetReviewApi createReview(VetReviewApiCreator vetReviewApiCreator) {
        var vetReview = vetReviewApiConverter.convertToEntity(vetReviewApiCreator);

        var vetReviewApi = vetReviewApiConverter.convertFromEntity(vetReviewRepository.save(vetReview));
        vetReviewClient.send(vetReviewApi);

        return vetReviewApi;
    }
}
