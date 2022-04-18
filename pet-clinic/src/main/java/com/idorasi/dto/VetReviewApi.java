package com.idorasi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;


@Getter
public class VetReviewApi {

    private String vetId;
    private Double rating;
    private String comment;
    private LocalDateTime date;

    @JsonCreator
    public VetReviewApi(
            @JsonProperty("vetId") String vetId,
            @JsonProperty("rating") Double rating,
            @JsonProperty("comment") String comment,
            @JsonProperty("date") LocalDateTime date) {
        this.vetId = vetId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }
}
