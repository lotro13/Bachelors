package com.bachelor.backend.domain.challenge;

import com.bachelor.backend.domain.users.UserPage;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableChallengePage.class)
@JsonDeserialize(as = ImmutableChallengePage.class)
public abstract class ChallengePage implements Serializable {

    public abstract UUID getUuid();

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getDeadline();

    public abstract ChallengeStatus getStatus();

    public abstract ChallengeType getType();

    public abstract boolean getCanManageStatus();

    public abstract boolean getCanCreatePost();

    public abstract boolean getCanCreateRatedPost();

    @Value.Default
    public Map<String, Integer> getScoreboard() {
        return Map.of();
    }
}
