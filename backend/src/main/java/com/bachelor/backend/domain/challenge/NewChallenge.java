package com.bachelor.backend.domain.challenge;

import com.bachelor.backend.domain.AccessType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableNewChallenge.class)
@JsonDeserialize(as = ImmutableNewChallenge.class)
public abstract class NewChallenge implements Serializable {

    public abstract UUID getFounder();

    public abstract UUID getGroup();

    public abstract String getName();

    public abstract String getDescription();

    public abstract ChallengeType getType();

    public abstract String getDeadline();

    public abstract AccessType getAccessType();

}
