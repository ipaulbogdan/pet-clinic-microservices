package com.idorasi.controller;

import com.idorasi.dto.owner.OwnerApi;
import com.idorasi.dto.owner.OwnerCreateApi;
import com.idorasi.service.OwnerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@Controller("/api/owners")
@AllArgsConstructor
@Secured(SecurityRule.IS_AUTHENTICATED)
public class OwnerController {

    private OwnerService ownerService;

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<OwnerApi> retrieveAllOwners() {
        return ownerService.retrieveAllOwners();
    }

    @Post
    public OwnerApi createOwner(@Body OwnerCreateApi ownerCreateApi) {
        return ownerService.saveOwner(ownerCreateApi);
    }

    @Delete("/{publicIdentifier}")
    public void deleteOwner(@PathVariable UUID publicIdentifier) {
        ownerService.deleteOwner(publicIdentifier);
    }
}
