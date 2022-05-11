package com.bachelor.backend.domain.feed;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableNewComment.class)
@JsonDeserialize(as = ImmutableNewComment.class)
public abstract class NewComment implements Serializable {

    public static NewComment create(UUID authorUuid, UUID targetUuid, String body) {
        return ImmutableNewComment.builder()
                .authorUuid(authorUuid)
                .targetUuid(targetUuid)
                .body(body)
                .build();
    }

    public abstract UUID getAuthorUuid();

    public abstract UUID getTargetUuid();

    public abstract String getBody();
}
