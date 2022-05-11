package com.bachelor.backend.api;

import com.bachelor.backend.domain.authentication.TokenRepository;
import com.bachelor.backend.domain.authentication.TokenRequest;
import com.bachelor.backend.domain.users.*;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Inject
    MockMvc mockMvc;
    @Inject
    UsersRepository usersRepository;
    @Inject
    TokenRepository tokenRepository;
    @Autowired
    private Gson gson;

    @BeforeEach
    public void clearData() {
        usersRepository.clear();
        tokenRepository.clear();
    }

    @Test
    public void it_should_be_possible_to_register_a_new_user() throws Exception {
        final String email = "monke@puretracker.lt";
        final NewUser newUser = ImmutableNewUser.builder()
                .email(email)
                .username("")
                .build();

        this.mockMvc.perform(
                        post("/auth/registerNewUser")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(newUser))
                )
                .andExpect(status().is2xxSuccessful());

        final List<User> savedUsers = usersRepository.findAll();
        assertThat(savedUsers, hasSize(1));
    }

    @Test
    public void requesting_authorization_should_create_new_token() throws Exception {
        createUser();

        this.mockMvc.perform(
                        post("/auth/tokenRequest")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(gson.toJson(new TokenRequest("mock@mock")))
                )
                .andExpect(status().is2xxSuccessful());

        UserValidationToken token = tokenRepository.findTokenByEmail("mock@mock").get();
        assertThat(token.getToken().length(), greaterThanOrEqualTo(6));
    }

    @Test
    public void entering_bad_token_should_fail_authorization() {

    }


    private void createUser() {
        final User user = User.initialize("mock@mock");
        usersRepository.save(user);
    }
}
