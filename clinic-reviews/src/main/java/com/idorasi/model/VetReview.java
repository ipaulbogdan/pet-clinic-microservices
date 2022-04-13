package com.idorasi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@MappedEntity(value = "vet_reviews")
public class VetReview {

    @Id
    @GeneratedValue
    private ObjectId id;
    private String publicId;
    private String vetId;
    private Double rating;
    private String comment;

    @Builder.Default
    private LocalDateTime creationDate = LocalDateTime.now();

    @Builder
    @BsonCreator
    public VetReview(ObjectId id, String publicId, String vetId, Double rating, String comment, LocalDateTime creationDate) {
        this.id = id;
        this.publicId = publicId;
        this.vetId = vetId;
        this.rating = rating;
        this.comment = comment;
        this.creationDate = creationDate;
    }
}
