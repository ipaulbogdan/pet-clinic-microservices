package com.idorasi.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VetReviewApi {

    private String publicId;
    private String vetId;
    private Double rating;
    private String comment;
    private LocalDateTime date;

}
