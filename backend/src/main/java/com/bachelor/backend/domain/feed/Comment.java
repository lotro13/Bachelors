package com.bachelor.backend.domain.feed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableComment.class)
@JsonDeserialize(as = ImmutableComment.class)
public abstract class Comment implements Serializable {

    public static Comment initialize(UUID authorUuid, UUID targetUuid, String body) {
        return create(UUID.randomUUID(), authorUuid, targetUuid, body);
    }

    public static Comment create(UUID uuid, UUID authorUuid, UUID targetUuid, String body) {
        return ImmutableComment.builder()
                .uuid(uuid)
                .authorUuid(authorUuid)
                .targetUuid(targetUuid)
                .body(body)
                .timestamp(Instant.now().toString())
                .build();
    }

    public static Comment create(NewComment newComment) {
        return initialize(newComment.getAuthorUuid(), newComment.getTargetUuid(), newComment.getBody());
    }

    public ImmutableComment copy() {
        return ImmutableComment.copyOf(this);
    }

    public abstract UUID getUuid();

    public abstract UUID getAuthorUuid();

    public abstract UUID getTargetUuid();

    public abstract String getBody();

    public abstract String getTimestamp();

    @Value.Default
    public String getAuthor() {
        return "NaN";
    }

    @JsonIgnore
    public Instant getTime() {
        return Instant.parse(getTimestamp());
    }
}
