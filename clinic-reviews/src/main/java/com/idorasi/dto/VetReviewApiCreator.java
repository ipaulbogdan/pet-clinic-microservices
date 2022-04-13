package com.idorasi.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VetReviewApiCreator {

    private Double rating;
    private String comment;
    private String vetId;
}
