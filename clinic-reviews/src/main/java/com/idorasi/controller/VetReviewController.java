package com.idorasi.controller;

import com.idorasi.dto.VetReviewApi;
import com.idorasi.dto.VetReviewApiCreator;
import com.idorasi.service.VetReviewService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.AllArgsConstructor;

import java.util.List;

@Controller("/api/vet-reviews")
@AllArgsConstructor
public class VetReviewController {

    private VetReviewService vetReviewService;

    @Get
    public List<VetReviewApi> getAll() {
        return vetReviewService.retrieveAllReviews();
    }

    @Post
    public VetReviewApi post(@Body VetReviewApiCreator vetReviewApiCreator) {
        return vetReviewService.createReview(vetReviewApiCreator);
    }
}
