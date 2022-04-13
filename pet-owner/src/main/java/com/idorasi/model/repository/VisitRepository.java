package com.idorasi.model.repository;

import com.idorasi.model.Visit;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
