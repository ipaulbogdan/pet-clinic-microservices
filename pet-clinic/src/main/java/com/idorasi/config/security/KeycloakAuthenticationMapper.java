package com.idorasi.config.security;

import io.micronaut.context.annotation.Property;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.rxjava2.http.client.RxHttpClient;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.oauth2.endpoint.authorization.state.State;
import io.micronaut.security.oauth2.endpoint.token.response.OauthAuthenticationMapper;
import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;
import io.reactivex.Flowable;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

import java.util.Map;


@Singleton
@Slf4j
@AllArgsConstructor
public class KeycloakAuthenticationMapper implements OauthAuthenticationMapper {

    @Property(name = "micronaut.security.oauth2.clients.keycloak.client-id")
    private String clientId;

    @Property(name = "micronaut.security.oauth2.clients.keycloak.client-secret")
    private String clientSecret;

    @Client("http://localhost:7080")
    private RxHttpClient client;

    @Override
    public Publisher<AuthenticationResponse> createAuthenticationResponse(TokenResponse tokenResponse, @Nullable State state) {
        Flowable<HttpResponse<KeycloakUser>> res = client.exchange(HttpRequest.POST("/auth/realms/master/protocol/openid-connect/token/introspect", KeycloakUser.class)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .basicAuth(clientId, clientSecret), KeycloakUser.class);

        return res.map(response -> {
            log.info("User: " + response.getBody());
            return AuthenticationResponse.success(response.getBody().get().getUsername(), response.getBody().get().getRoles(), Map.of("openIdToken", tokenResponse.getAccessToken()));
        });
    }
}
