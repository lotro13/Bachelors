package com.bachelor.backend.domain.authentication;

import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UserValidationToken;
import com.bachelor.backend.domain.users.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Service
public class AuthenticationService {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Inject
    UsersRepository usersRepository;

    @Inject
    TokenRepository tokenRepository;

    public void registerNewUser(String email, String username) {
        final User user = User.initialize(email, username);
        usersRepository.save(user);

        final UserValidationToken newToken = tokenRepository.createNewToken(email);
        LOG.info("New user {} registered, with token: {}", newToken.getEmail(), newToken.getToken());
    }

    public void requestNewToken(String email) {
        final UserValidationToken newToken = tokenRepository.createNewToken(email);
        LOG.info("Token for user {} created: {}", newToken.getEmail(), newToken.getToken());
    }

    public String enterToken(String email, String myToken) {
        final boolean isTokenValid = tokenRepository.isTokenValid(email, myToken);

        if (isTokenValid) {
            usersRepository.validateUser(email);

            tokenRepository.invalidateToken(email, myToken);
            return "Token validated";
        }

        return "Token check failed";
    }
}
