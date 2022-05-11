package com.bachelor.backend.domain.users;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableUserPage.class)
@JsonDeserialize(as = ImmutableUserPage.class)
public abstract class UserPage implements Serializable {

    public static UserPage create(User user) {
        return ImmutableUserPage.builder()
                .uuid(user.getUuid())
                .username(user.getUsername())
                .build();
    }

    public abstract UUID getUuid();

    public abstract String getUsername();
}
