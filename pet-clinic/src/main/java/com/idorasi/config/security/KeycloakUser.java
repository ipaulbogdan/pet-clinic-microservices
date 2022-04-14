package com.idorasi.config.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class KeycloakUser {

    private String email;
    private String username;
    private List<String> roles;
}
