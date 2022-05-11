package com.bachelor.backend.domain.authentication;

import com.bachelor.backend.domain.users.UserValidationToken;
import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
@Repository
public class TokenRepository {

    List<UserValidationToken> tokens = List.of();

    public UserValidationToken createNewToken(String email) {
        final UserValidationToken newToken = UserValidationToken.create(email);
        final var newTokens = new ArrayList<>(tokens);
        newTokens.add(newToken);
        tokens = newTokens;
        return newToken;
    }

    public void save(UserValidationToken token) {
        final var newTokens = new ArrayList<>(tokens);
        newTokens.add(token);
        tokens = newTokens;
    }

    public List<UserValidationToken> findAll() {
        return tokens;
    }

    public Optional<UserValidationToken> findTokenByEmail(String email) {
        return tokens.stream()
                .filter(t -> t.getEmail().equals(email))
                .findFirst();
    }

    public boolean isTokenValid(String email, String token) {
        return tokens.stream()
                .anyMatch(t -> t.getEmail().equals(email) && t.getToken().equals(token));
    }

    public void invalidateToken(String email, String token) {
        final List<UserValidationToken> collect = tokens.stream()
                .filter(t -> !(t.getEmail().equals(email) && t.getToken().equals(token)))
                .collect(Collectors.toList());
        tokens = collect;
    }

    public void clear() {
        tokens = List.of();
    }
}
