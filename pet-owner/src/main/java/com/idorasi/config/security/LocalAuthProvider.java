package com.idorasi.config.security;

import com.idorasi.config.LocalIdentityStore;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import org.reactivestreams.Publisher;

import java.util.List;

@Singleton
@AllArgsConstructor
public class LocalAuthProvider implements AuthenticationProvider {

    private LocalIdentityStore localIdentityStore;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        var username = (String) authenticationRequest.getIdentity();
        var providedPassword = (String) authenticationRequest.getSecret();

        var password = localIdentityStore.getUserPassword(username);
        if (password.isPresent() && password.get().equals(providedPassword)) {
            return Flowable.just(AuthenticationResponse.success(username, List.of(localIdentityStore.getUserRole(username))));
        }

        return Flowable.just(AuthenticationResponse.failure());
    }
}
