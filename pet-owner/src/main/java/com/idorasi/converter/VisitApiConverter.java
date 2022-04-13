package com.idorasi.converter;

import com.idorasi.dto.visit.VisitApi;
import com.idorasi.model.Visit;

public class VisitApiConverter {

    public static VisitApi convertFromEntity(Visit visit) {
        return VisitApi.builder()
                .publicIdentifier(visit.getPublicIdentifier())
                .visitDate(visit.getVisitDate())
                .description(visit.getDescription())
                .petApi(PetApiConverter.convertFromEntity(visit.getPet()))
                .build();
    }
}
