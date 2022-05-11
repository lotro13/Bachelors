package com.bachelor.backend.domain.group;

import com.bachelor.backend.domain.AccessType;
import com.bachelor.backend.domain.users.UserPage;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Value.Immutable
@JsonSerialize(as = ImmutableGroupPage.class)
@JsonDeserialize(as = ImmutableGroupPage.class)
public abstract class GroupPage implements Serializable {

    public abstract UUID getUuid();

    public abstract AccessType getAccessType();

    public abstract String getName();

    public abstract boolean getCanCreateChallenge();

    public abstract boolean getCanManageUsers();

    public abstract boolean getIsMember();

    public abstract boolean getIsRequestPending();

    public abstract List<UserPage> getMembers();

    @Value.Default
    public List<UserPage> getPendingRequests() {
        return List.of();
    }

    @Value.Default
    public Map<String, Integer> getScoreboard() {
        return Map.of();
    }
}
