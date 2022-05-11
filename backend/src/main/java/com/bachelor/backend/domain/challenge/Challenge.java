package com.bachelor.backend.domain.challenge;

import com.bachelor.backend.domain.AccessType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Value.Immutable
@JsonSerialize(as = ImmutableChallenge.class)
@JsonDeserialize(as = ImmutableChallenge.class)
public abstract class Challenge implements Serializable {

    public ImmutableChallenge copy() {
        return ImmutableChallenge.copyOf(this);
    }

    public static Challenge initialize(UUID founder, UUID group, String name, String description, LocalDateTime deadline) {
        return Challenge.create(UUID.randomUUID(), founder, group, name, description, deadline);
    }

    public static Challenge create(UUID uuid, UUID founder, UUID group, String name, String description, LocalDateTime deadline) {
        return ImmutableChallenge.builder()
                .uuid(uuid)
                .founder(founder)
                .participants(Collections.singleton(founder))
                .group(group)
                .name(name)
                .deadline(deadline.toString())
                .accessType(AccessType.PUBLIC)
                .description(description)
                .type(ChallengeType.HABIT)
                .status(ChallengeStatus.IDLE)
                .scoreboard(Map.of(founder, 0))
                .build();
    }

    public static Challenge create(NewChallenge newChallenge) {
        return initialize(
                newChallenge.getFounder(),
                newChallenge.getGroup(),
                newChallenge.getName(),
                newChallenge.getDescription(),
                LocalDateTime.parse(newChallenge.getDeadline())
        );
    }

    public abstract UUID getUuid();

    public abstract UUID getFounder();

    public abstract UUID getGroup();

    public abstract List<UUID> getParticipants();

    public abstract String getName();

    public abstract String getDescription();

    public abstract ChallengeType getType();

    public abstract ChallengeStatus getStatus();

    public abstract String getDeadline();

    public abstract Map<UUID, Integer> getScoreboard();

    public abstract AccessType getAccessType();

    @JsonIgnore
    public Challenge addParticipant(UUID newMember) {
        final var newParticipants = new ArrayList<>(getParticipants());
        newParticipants.add(newMember);
        final var newScoreBoard = new HashMap<>(getScoreboard());
        newScoreBoard.put(newMember, 0);

        return copy()
                .withParticipants(newParticipants)
                .withScoreboard(newScoreBoard);
    }

    @JsonIgnore
    public Challenge removeParticipants(UUID newMember) {
        final var newParticipants = new ArrayList<>(getParticipants());
        newParticipants.remove(newMember);

        return copy()
                .withParticipants(newParticipants);
    }

    @JsonIgnore
    public Challenge updateScoreboard(Map<UUID, Integer> scoreboard) {
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
}
