package com.idorasi.controller;

import com.idorasi.dto.visit.VisitApi;
import com.idorasi.service.VisitService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.AllArgsConstructor;

import java.util.List;

@Controller("/api/visits")
@AllArgsConstructor
public class VisitController {

    private VisitService visitService;

    @Get
    public List<VisitApi> getAllVisits() {
        return visitService.retrieveAllVisits();
    }

}
