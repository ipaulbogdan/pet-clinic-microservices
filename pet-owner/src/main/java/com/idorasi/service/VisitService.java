package com.idorasi.service;

import com.idorasi.converter.VisitApiConverter;
import com.idorasi.dto.visit.VisitApi;
import com.idorasi.model.repository.VisitRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
public class VisitService {

    private VisitRepository visitRepository;

    @Transactional
    public List<VisitApi> retrieveAllVisits() {
        return visitRepository.findAll().stream()
                .map(VisitApiConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

}

