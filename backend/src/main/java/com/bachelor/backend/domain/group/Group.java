package com.bachelor.backend.domain.group;

import com.bachelor.backend.domain.AccessType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Value.Immutable
@JsonSerialize(as = ImmutableGroup.class)
@JsonDeserialize(as = ImmutableGroup.class)
public abstract class Group implements Serializable {

    public ImmutableGroup copy() {
        return ImmutableGroup.copyOf(this);
    }

    public static Group initialize(UUID founder, String name, AccessType accessType) {
        return Group.create(UUID.randomUUID(), founder, name, accessType);
    }

    public static Group create(NewGroup newGroup) {
        return initialize(newGroup.getFounder(), newGroup.getName(), newGroup.getAccessType());
    }

    public static Group create(UUID uuid, UUID founder, String name, AccessType accessType) {
        return ImmutableGroup.builder()
                .uuid(uuid)
                .founder(founder)
                .moderators(Collections.singleton(founder))
                .members(Collections.singleton(founder))
                .accessType(accessType)
                .name(name)
                .scoreboard(Map.of(founder, 0))
                .build();
    }

    public abstract UUID getUuid();

    public abstract AccessType getAccessType();

    public abstract String getName();

    public abstract UUID getFounder();

    public abstract List<UUID> getModerators();

    public abstract List<UUID> getMembers();

    @Value.Default
    public List<UUID> getPendingRequests() {
        return List.of();
    }

    public abstract Map<UUID, Integer> getScoreboard();

    @JsonIgnore
    public Group addGroupMember(UUID newMember) {
        final var newMembers = new ArrayList<>(getMembers());
        newMembers.add(newMember);
        final var newPendingRequests = new ArrayList<>(getPendingRequests());
        newPendingRequests.remove(newMember);
        final var newScoreBoard = new HashMap<>(getScoreboard());
        newScoreBoard.put(newMember, 0);

        return copy()
                .withMembers(newMembers)
                .withPendingRequests(newPendingRequests)
                .withScoreboard(newScoreBoard);
    }

    @JsonIgnore
    public Group addUserJoinRequest(UUID userUuid) {
        final var newPendingRequests = new ArrayList<>(getPendingRequests());
        newPendingRequests.add(userUuid);

        return copy()
                .withPendingRequests(newPendingRequests);
    }

    @JsonIgnore
    public Group declineJoinRequest(UUID targetUuid) {
        final var newPendingRequests = new ArrayList<>(getPendingRequests());
        newPendingRequests.remove(targetUuid);

        return copy()
                .withPendingRequests(newPendingRequests);
    }

    @JsonIgnore
    public Group updateScoreBoard(Map<UUID, Integer> scoreboard) {
        final var newScoreboard = (HashMap<UUID, Integer>) getScoreboard().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, p -> {
                    if (scoreboard.containsKey(p.getKey())) {
                        return p.getValue() + scoreboard.get(p.getKey());
                    }

                    return p.getValue();
                }));

        return copy()
                .withScoreboard(newScoreboard);
    }

    @JsonIgnore
    public Group removeMember(UUID userUuid) {
        final var newMembers = new ArrayList<>(getMembers());
        newMembers.remove(userUuid);

        return copy()
                .withMembers(newMembers);
    }
}
