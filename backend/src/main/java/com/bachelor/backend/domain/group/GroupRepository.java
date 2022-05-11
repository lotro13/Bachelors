package com.bachelor.backend.domain.group;

import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
@Repository
public class GroupRepository {

    private List<Group> groups = List.of();

    public List<Group> findAll() {
        return groups;
    }

    public void saveAll(List<Group> groups) {
        final ArrayList<Group> newGroups = new ArrayList<>(new ArrayList<>(this.groups));
        newGroups.addAll(groups);
        this.groups = newGroups;
    }

    public void save(Group group) {
        final ArrayList<Group> newGroups = new ArrayList<>(new ArrayList<>(groups));
        newGroups.add(group);
        groups = newGroups;
    }

    public Optional<Group> findByUuid(UUID uuid) {
        return groups.stream()
                .filter(g -> g.getUuid().equals(uuid))
                .findFirst();
    }

    public void clear() {
        groups = List.of();
    }

    public List<Group> finUserGroups(UUID userUuid) {
        return groups.stream()
                .filter(g -> g.getMembers().contains(userUuid))
                .collect(Collectors.toList());
    }

    public List<Group> findByFounder(UUID userUuid) {
        return groups.stream()
                .filter(g -> g.getFounder().equals(userUuid))
                .collect(Collectors.toList());
    }

    public void update(Group updatedGroup) {
        groups = groups.stream()
                .map(g -> {
                    if (g.getUuid().equals(updatedGroup.getUuid())) {
                        return updatedGroup;
                    }
                    return g;
                })
                .collect(Collectors.toList());
    }
}
