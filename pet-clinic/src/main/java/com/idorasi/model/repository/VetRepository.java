package com.idorasi.model.repository;

import com.idorasi.model.Vet;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

@MongoRepository
public interface VetRepository extends CrudRepository<Vet, String> {

    Optional<Vet> findByLastName(String lastName);

    @NonNull
    List<Vet> findAll();
}
