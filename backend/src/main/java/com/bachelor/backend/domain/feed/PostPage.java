package com.bachelor.backend.domain.feed;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutablePostPage.class)
@JsonDeserialize(as = ImmutablePostPage.class)
public abstract class PostPage implements Serializable {

    public abstract UUID getUuid();

    public abstract String getAuthorName();

    public abstract String getTitle();

    public abstract String getDescription();

    public abstract String getBodyURL();

    public abstract int getNumberOfComments();
}
