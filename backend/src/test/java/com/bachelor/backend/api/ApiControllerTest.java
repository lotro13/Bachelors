package com.bachelor.backend.api;

import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.group.GroupRepository;
import com.bachelor.backend.domain.users.UsersRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static com.bachelor.backend.MockData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {


    @Inject
    MockMvc mockMvc;
    @Inject
    private GroupRepository groupRepository;
    @Inject
    private ChallengesRepository challengesRepository;
    @Inject
    private UsersRepository usersRepository;

    @Autowired
    private Gson gson;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void clearData() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        usersRepository.clear();
        groupRepository.clear();
        challengesRepository.clear();
    }

    private void populateData() {
        usersRepository.saveAll(USERS);
        groupRepository.saveAll(GROUPS);
        challengesRepository.saveAll(CHALLENGES);
    }


    @Test
    public void requesting_users_general_feed_should_work() throws Exception {
        mockMvc.perform(get("/api/feed"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void requesting_users_group_feed_should_work() throws Exception {
        mockMvc.perform(get("/api/feed?groupUuid="))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void requesting_users_challenge_feed_should_work() throws Exception {
        mockMvc.perform(get("/api/feed?challengeUuid="))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void requesting_users_groups_should_work() throws Exception {
        mockMvc.perform(get("/api/groups?uuid="))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void requesting_group_feed_should_work() throws Exception {
        mockMvc.perform(get("/api/feed?targetUuid="))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void requesting_group_challenges_should_work() throws Exception {
        mockMvc.perform(get("/api/challenges?uuid="))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void requesting_challenge_feed_should_work() throws Exception {
        mockMvc.perform(get("/api/feed?target="))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void request_user_infO_should_work() throws Exception {
        mockMvc.perform(get("/api/users?uuid="))
                .andExpect(status().is2xxSuccessful());
    }
}
