package com.idorasi.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.UUID;

@MappedEntity(value = "vets")
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Vet {

    @Id
    @GeneratedValue(value = GeneratedValue.Type.UUID)
    String id;
    UUID publicId;
    String firstName;
    String lastName;
    String speciality;

    @BsonCreator
    @Builder
    public Vet(
            @BsonProperty("_id") String id,
            @BsonProperty("publicId") UUID publicId,
            @BsonProperty("firstName") String firstName,
            @BsonProperty("lastName") String lastName,
            @BsonProperty("speciality") String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.publicId = publicId;
        this.lastName = lastName;
        this.speciality = speciality;
    }
}
