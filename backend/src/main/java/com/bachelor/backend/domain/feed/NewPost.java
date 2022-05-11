package com.bachelor.backend.domain.feed;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableNewPost.class)
@JsonDeserialize(as = ImmutableNewPost.class)
public abstract class NewPost implements Serializable {

    public abstract UUID getAuthor();

    public abstract UUID getTarget();

    public abstract String getTitle();

    public abstract String getDescription();

    public abstract String getBodyURL();

    public abstract boolean getIsRated();
}
