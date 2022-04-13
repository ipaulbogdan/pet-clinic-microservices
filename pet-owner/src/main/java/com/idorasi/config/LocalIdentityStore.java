package com.idorasi.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;

import java.util.Map;
import java.util.Optional;

@ConfigurationProperties("identity-store")
public class LocalIdentityStore {

    @MapFormat Map<String, String> users;
    @MapFormat Map<String, String> roles;

    public Optional<String> getUserPassword(String username) {
        return users.containsKey(username) ? Optional.of(users.get(username)) : Optional.empty();
    }
    public String getUserRole(String username) {
        return roles.get(username);
    }
}
