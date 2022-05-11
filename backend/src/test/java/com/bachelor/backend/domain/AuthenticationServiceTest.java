package com.bachelor.backend.domain;

import com.bachelor.backend.domain.authentication.AuthenticationService;
import com.bachelor.backend.domain.authentication.TokenRepository;
import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UserRegistrationStatus;
import com.bachelor.backend.domain.users.UserValidationToken;
import com.bachelor.backend.domain.users.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class AuthenticationServiceTest {

    @Inject
    AuthenticationService authenticationService;

    @Inject
    TokenRepository tokenRepository;

    @Inject
    UsersRepository usersRepository;

    @BeforeEach
    public void clearEnv() {
        tokenRepository.clear();
        usersRepository.clear();
    }

    @Test
    public void after_new_user_was_registered_new_token_should_appear() {
        authenticationService.registerNewUser("mock@mock.mock", "mock");

        var tokens = tokenRepository.findAll();
        assertThat(tokens, hasSize(1));
    }

    @Test
    public void it_should_be_possible_to_create_register_a_new_user() {
        authenticationService.registerNewUser("mock@mock.mock", "mock");
        List<User> allSavedUsers = usersRepository.findAll();
        assertThat(allSavedUsers, hasSize(1));
    }

    @Test
    public void after_correct_user_token_was_entered_user_should_become_validated() {
        User newUser = User.initialize("mock@mock.mock");

        usersRepository.save(newUser);
        final var newToken = UserValidationToken.createCustom("mock@mock.mock", "myToken");
        tokenRepository.save(newToken);
        authenticationService.enterToken("mock@mock.mock", "myToken");

        User savedUser = usersRepository.findByUuid(newUser.getUuid()).get();
        assertThat(savedUser.getRegistrationStatus(), equalTo(UserRegistrationStatus.VALIDATED));
    }

    @Test
    public void after_existing_token_was_entered_it_Should_be_deleted() {
        final var newToken = UserValidationToken.createCustom("mock@mock.mock", "myToken");
        tokenRepository.save(newToken);

        authenticationService.enterToken("mock@mock.mock", "myToken");

        List<UserValidationToken> tokens = tokenRepository.findAll();
        assertThat(tokens, hasSize(0));
    }
}
