package com.idorasi.model.repository;

import com.idorasi.model.Pet;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
