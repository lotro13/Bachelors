package com.bachelor.backend.domain.users;

import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
@Repository
public class UsersRepository {

    List<User> users = List.of();

    public List<User> findAll() {
        return users;
    }

    public void saveAll(List<User> users) {
        final var newUsers = new ArrayList<>(this.users);
        newUsers.addAll(users);

        this.users = newUsers;
    }

    public void save(User newUser) {
        final var newUsers = new ArrayList<>(users);
        newUsers.add(newUser);

        users = newUsers;
    }

    public Optional<User> findByUuid(UUID uuid) {
        return users.stream()
                .filter(u -> u.getUuid().equals(uuid))
                .findFirst();
    }

    public void validateUser(String email) {
        users = users.stream()
                .map(u -> {
                    if (u.getEmail().equals(email)) {
                        return u.copy()
                                .withRegistrationStatus(UserRegistrationStatus.VALIDATED);
                    }
                    return u;
                })
                .collect(Collectors.toList());
    }

    public void clear() {
        users = List.of();
    }

    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
    }
}
