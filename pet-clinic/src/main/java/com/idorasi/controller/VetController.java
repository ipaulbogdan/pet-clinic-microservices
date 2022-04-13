package com.idorasi.controller;

import com.idorasi.dto.VetApi;
import com.idorasi.dto.VetCreateApi;
import com.idorasi.service.VetService;
import io.micronaut.http.annotation.*;
import lombok.AllArgsConstructor;

import java.util.List;

@Controller("/api/vets")
@AllArgsConstructor
public class VetController {

    private VetService vetService;

    @Get
    public List<VetApi> getAll() {
        return vetService.findAllVets();
    }

    @Post
    public VetApi post(@Body VetCreateApi vetCreateApi) {
        return vetService.createVet(vetCreateApi);
    }

    @Delete("/lastName/{lastName}")
    public void delete(@PathVariable String lastName) {
        vetService.deleteVet(lastName);
    }

}
