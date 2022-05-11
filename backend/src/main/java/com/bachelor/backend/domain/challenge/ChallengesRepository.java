package com.bachelor.backend.domain.challenge;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ChallengesRepository {
    private List<Challenge> challenges = List.of();

    public Optional<Challenge> findByUuid(UUID uuid) {
        return challenges.stream()
                .filter(c -> c.getUuid().equals(uuid))
                .findFirst();
    }

    public void saveAll(List<Challenge> challenges) {
        final var newChallenges = new ArrayList<>(this.challenges);
        newChallenges.addAll(challenges);
        this.challenges = newChallenges;
    }

    public void save(Challenge newChallenge) {
        final var newChallenges = challenges.stream()
                .filter(c -> !c.getUuid().equals(newChallenge.getUuid()))
                .collect(Collectors.toList());
        newChallenges.add(newChallenge);
        challenges = newChallenges;
    }

    public void clear() {
        challenges = List.of();
    }

    public List<Challenge> findUserChallenges(UUID userUuid) {
        return challenges.stream()
                .filter(c -> c.getParticipants().contains(userUuid))
                .collect(Collectors.toList());
    }

    public List<Challenge> findByFounder(UUID userUuid) {
        return challenges.stream()
                .filter(c -> c.getFounder().equals(userUuid))
                .collect(Collectors.toList());
    }

    public void update(Challenge newChallenge) {
        challenges = challenges.stream()
                .map(c -> {
                    if (c.getUuid().equals(newChallenge.getUuid())) {
                        return newChallenge;
                    }

                    return c;
                })
                .collect(Collectors.toList());
    }

    public List<Challenge> findByGroup(UUID groupUuid) {
        return challenges.stream()
                .filter(c -> c.getGroup().equals(groupUuid))
                .collect(Collectors.toList());
    }

    public List<Challenge> findUserChallengesInGroup(UUID userUuid, UUID groupUuid) {
        return challenges.stream()
                .filter(c -> c.getGroup().equals(groupUuid))
                .filter(c -> c.getParticipants().contains(userUuid))
                .collect(Collectors.toList());
    }

    public List<Challenge> findAll() {
        return challenges;
    }
}
