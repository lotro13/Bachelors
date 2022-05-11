package com.bachelor.backend.domain.users;


import org.immutables.value.Value;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Value.Immutable
public abstract class UserValidationToken {

    public static UserValidationToken create(String email) {
        final Instant inspirationDate = Instant.now().plus(1, ChronoUnit.DAYS);
        return ImmutableUserValidationToken.builder()
                .uuid(UUID.randomUUID())
                .token("SomeToken")
                .email(email)
                .inspirationDate(inspirationDate)
                .build();
    }

    public static UserValidationToken createCustom(String email, String customToken) {
        final Instant inspirationDate = Instant.now().plus(1, ChronoUnit.DAYS);
        return ImmutableUserValidationToken.builder()
                .uuid(UUID.randomUUID())
                .token(customToken)
                .email(email)
                .inspirationDate(inspirationDate)
                .build();
    }

    public abstract UUID getUuid();

    public abstract String getToken();

    public abstract Instant getInspirationDate();

    public abstract String getEmail();
}
