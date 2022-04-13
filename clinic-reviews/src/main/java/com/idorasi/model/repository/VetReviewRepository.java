package com.idorasi.model.repository;

import com.idorasi.model.VetReview;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import lombok.NonNull;
import org.bson.types.ObjectId;

import java.util.List;

@MongoRepository
public interface VetReviewRepository extends CrudRepository<VetReview, ObjectId> {

    @NonNull List<VetReview> findAll();

}
