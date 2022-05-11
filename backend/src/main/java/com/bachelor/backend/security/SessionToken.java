package com.bachelor.backend.security;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public abstract class SessionToken {

    public static SessionToken initialize(UUID userUuid) {
        return ImmutableSessionToken.builder()
                .userUuid(userUuid)
                .token("myToken")
                .build();
    }

    public abstract UUID getUserUuid();

    public abstract String getToken();
}
