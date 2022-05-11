package com.bachelor.backend.domain.users;


import com.bachelor.backend.domain.feed.ImmutableNewPost;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;

@Value.Immutable
@JsonSerialize(as = ImmutableNewUser.class)
@JsonDeserialize(as = ImmutableNewUser.class)
public abstract class NewUser implements Serializable {
    public abstract String getEmail();

    public abstract String getUsername();
}
