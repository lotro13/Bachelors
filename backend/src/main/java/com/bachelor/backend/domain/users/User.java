package com.bachelor.backend.domain.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.serial.Serial;
import org.immutables.value.Value;

import java.time.Instant;
import java.util.UUID;


@Value.Immutable
@Serial.Structural
@Value.Style(forceJacksonPropertyNames = false)
@JsonSerialize(as = ImmutableUser.class)
@JsonDeserialize(as = ImmutableUser.class)
public abstract class User {

    @JsonIgnore
    public ImmutableUser copy() {
        return ImmutableUser.copyOf(this);
    }

    public static User initialize(String email) {
        return ImmutableUser.builder()
                .uuid(UUID.randomUUID())
                .email(email)
//                .creationTime(Instant.now())
                .registrationStatus(UserRegistrationStatus.WAITING_VALIDATION)
                .build();
    }

    public static User initialize(String email, String username) {
        return ImmutableUser.builder()
                .uuid(UUID.randomUUID())
                .email(email)
                .username(username)
//                .creationTime(Instant.now())
                .registrationStatus(UserRegistrationStatus.WAITING_VALIDATION)
                .build();
    }

    public static User create(UUID uuid, String email, String username, Instant creationTime, UserRegistrationStatus registrationStatus) {
        return ImmutableUser.builder()
                .uuid(uuid)
                .email(email)
                .username(username)
//                .creationTime(creationTime)
                .registrationStatus(registrationStatus)
                .build();
    }

    public abstract UUID getUuid();
    public abstract String getEmail();

    @Value.Default
    public String getUsername() {
        return "Default username";
    }
//    public abstract Instant getCreationTime();
    public abstract UserRegistrationStatus getRegistrationStatus();

//    public User(String username, String email) {
//        uuid = UUID.randomUUID();
//        this.username = username;
//        this.email = email;
//        creationTime = Instant.now();
//        registrationStatus = UserRegistrationStatus.WAITING_VALIDATION;
//    }
}
