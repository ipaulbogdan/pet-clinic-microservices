package com.idorasi.converter;

import com.idorasi.dto.VetReviewApi;
import com.idorasi.dto.VetReviewApiCreator;
import com.idorasi.model.VetReview;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class VetReviewApiConverter {

    public VetReviewApi convertFromEntity(VetReview vetReview) {
        return VetReviewApi.builder()
                .publicId(vetReview.getPublicId())
                .vetId(vetReview.getVetId())
                .rating(vetReview.getRating())
                .comment(vetReview.getComment())
                .date(vetReview.getCreationDate())
                .build();
    }

    public VetReview convertToEntity(VetReviewApiCreator vetReviewApiCreator) {
        return VetReview.builder()
                .publicId(UUID.randomUUID().toString())
                .rating(vetReviewApiCreator.getRating())
                .comment(vetReviewApiCreator.getComment())
                .vetId(vetReviewApiCreator.getVetId())
                .build();
    }
}
