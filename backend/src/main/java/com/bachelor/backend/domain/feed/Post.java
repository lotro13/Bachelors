package com.bachelor.backend.domain.feed;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutablePost.class)
@JsonDeserialize(as = ImmutablePost.class)
public abstract class Post implements Serializable {

    public static Post create(UUID uuid, UUID userUuid, UUID targetUuid, String title, String description, String someImage, int numberOfComments) {
        return ImmutablePost.builder()
                .uuid(uuid)
                .author(userUuid)
                .target(targetUuid)
                .title(title)
                .description(description)
//                .bodyURL("./api/files/" + someImage)
                .bodyURL(someImage)
                .numberOfComments(numberOfComments)
                .build();
    }

    public static Post create(NewPost newPost) {
        return initialize(newPost.getAuthor(), newPost.getTarget(), newPost.getTitle(), newPost.getDescription(), newPost.getBodyURL()).copy()
                .withIsRated(newPost.getIsRated());
    }

    public static Post initialize(UUID userUuid, UUID targetUuid, String name, String description, String someImage) {
        return create(UUID.randomUUID(), userUuid, targetUuid, name, description, someImage, 0);
    }

    public static Post initialize(UUID userUuid, UUID targetUuid, String name, String someImage) {
        return create(UUID.randomUUID(), userUuid, targetUuid, name, "", someImage, 0);
    }

    public ImmutablePost copy() {
        return ImmutablePost.copyOf(this);
    }

    public abstract UUID getUuid();

    public abstract UUID getAuthor();

    public abstract UUID getTarget();

    public abstract String getTitle();

    public abstract String getDescription();

    public abstract String getBodyURL();

    public abstract int getNumberOfComments();

    @Value.Default
    public boolean getIsRated() {
        return false;
    }
}
