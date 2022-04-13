package com.idorasi.controller;

import com.idorasi.dto.pet.PetApi;
import com.idorasi.service.PetService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.AllArgsConstructor;

import java.util.List;

@Controller("/api/pets")
@AllArgsConstructor
public class PetController {

    private PetService petService;

    @Get
    public List<PetApi> getAllPets() {
        return petService.retrieveAllPets();
    }
}
