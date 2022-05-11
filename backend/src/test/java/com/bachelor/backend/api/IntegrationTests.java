package com.bachelor.backend.api;

import com.bachelor.backend.domain.AccessType;
import com.bachelor.backend.domain.challenge.*;
import com.bachelor.backend.domain.feed.Comment;
import com.bachelor.backend.domain.feed.CommentsRepository;
import com.bachelor.backend.domain.feed.Post;
import com.bachelor.backend.domain.feed.PostsRepository;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UserRegistrationStatus;
import com.bachelor.backend.domain.users.UsersRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Inject
    MockMvc mockMvc;
    @Autowired
    Gson gson;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Inject
    private GroupRepository groupRepository;
    @Inject
    private ChallengesRepository challengesRepository;
    @Inject
    private PostsRepository postsRepository;
    @Inject
    private UsersRepository usersRepository;
    @Inject
    private CommentsRepository commentsRepository;

    static final User user1 = User.initialize("1@mock").copy().withRegistrationStatus(UserRegistrationStatus.VALIDATED);
    static final User user2 = User.initialize("2@mock").copy().withRegistrationStatus(UserRegistrationStatus.VALIDATED);
    static final Group group1 = Group.initialize(user1.getUuid(), "group1", AccessType.PUBLIC);
    static final Challenge challenge1 = Challenge.initialize(user1.getUuid(), group1.getUuid(), "challenge1", "", LocalDateTime.now().plus(1, ChronoUnit.DAYS)).copy()
            .withStatus(ChallengeStatus.STARTED);
    static final Post post1 = Post.initialize(user1.getUuid(), challenge1.getUuid(), "post1", "", "image");


    @BeforeEach
    public void initializeData() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        usersRepository.clear();
        groupRepository.clear();
        challengesRepository.clear();
        postsRepository.clear();
        commentsRepository.clear();


        usersRepository.saveAll(List.of(user1, user2));
        groupRepository.save(group1);
        challengesRepository.save(challenge1);
        postsRepository.save(post1);
    }

    @Test
    public void joining_group_then_joining_challenge_and_creating_rated_post() throws Exception {
        // requesting to join public group
        mockMvc.perform(get("/api/groups/" + group1.getUuid() + "/join?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        // requesting to join public challenge
        mockMvc.perform(get("/api/challenges/" + challenge1.getUuid() + "/join?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        // creating ranked post
        final Post newPost = Post.initialize(user2.getUuid(), challenge1.getUuid(), "newPost", "description", "image");
        mockMvc.perform(post("/api/challenges/createRatedPost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(newPost)))
                .andExpect(status().isOk());

        final Challenge savedChallenge = challengesRepository.findByUuid(challenge1.getUuid()).get();
        final Integer userScore = savedChallenge.getScoreboard().get(user2.getUuid());
        assertThat(userScore, greaterThan(0));

        final var savedPost = postsRepository.findAll();
        assertThat(savedPost, hasSize(2));
    }

    @Test
    public void joining_group_then_joining_challenge_and_comment_under_post() throws Exception {
        // requesting to join public group
        mockMvc.perform(get("/api/groups/" + group1.getUuid() + "/join?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        // requesting to join public challenge
        mockMvc.perform(get("/api/challenges/" + challenge1.getUuid() + "/join?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        // write comment under post
        final Comment newComment = Comment.initialize(user2.getUuid(), post1.getUuid(), "Some random comment");
        mockMvc.perform(post("/api/feed/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(newComment)))
                .andExpect(status().isOk());

        final var savedComments = commentsRepository.findByTarget(post1.getUuid());
        assertThat(savedComments, hasSize(1));
    }

    @Test
    public void group_creation_starting_challenge_and_stopping_it() throws Exception {
        // create new group
        final Group newGroup = Group.initialize(user2.getUuid(), "newGroup", AccessType.PRIVATE);
        mockMvc.perform(post("/api/groups/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(newGroup)))
                .andExpect(status().isOk());

        final var savedGroups = groupRepository.findAll();
        assertThat(savedGroups, hasSize(2));

        final var group = savedGroups.stream()
                .filter(c -> c.getUuid() != group1.getUuid())
                .findFirst().get();

        // create new challenge
        final NewChallenge newChallenge = ImmutableNewChallenge.builder()
                .founder(user2.getUuid())
                .group(group.getUuid())
                .name("newChallenge")
                .description("")
                .type(ChallengeType.CHALLENGE)
                .deadline(LocalDateTime.now().plus(1, ChronoUnit.DAYS).toString())
                .accessType(AccessType.PUBLIC)
                .build();
        mockMvc.perform(post("/api/challenges/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(newChallenge)))
                .andExpect(status().isOk());

        final var savedChallenges = challengesRepository.findAll();
        assertThat(savedChallenges, hasSize(2));

        final Challenge challenge = savedChallenges.stream()
                .filter(c -> c.getUuid() != challenge1.getUuid())
                .findFirst().get();

        // start challenge
        mockMvc.perform(get("/api/challenges/start?userUuid=" + user2.getUuid() + "&challengeUuid=" + challenge.getUuid()))
                .andExpect(status().isOk());

        final Challenge startedChallenge = challengesRepository.findByUuid(challenge.getUuid()).get();
        assertThat(startedChallenge.getStatus(), equalTo(ChallengeStatus.STARTED));

        // stop created challenge
        mockMvc.perform(get("/api/challenges/close?userUuid=" + user2.getUuid() + "&challengeUuid=" + challenge.getUuid()))
                .andExpect(status().isOk());

        final Challenge closedChallenge = challengesRepository.findByUuid(challenge.getUuid()).get();
        assertThat(closedChallenge.getStatus(), equalTo(ChallengeStatus.CLOSED));
    }

    @Test
    public void joining_group_and_leaving() throws Exception {
        // requesting to join public group
        mockMvc.perform(get("/api/groups/" + group1.getUuid() + "/join?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        final Group joinedGroup = groupRepository.findByUuid(group1.getUuid()).get();
        assertThat(joinedGroup.getMembers(), hasItem(user2.getUuid()));

        // leaving group
        mockMvc.perform(get("/api/groups/" + group1.getUuid() + "/leave?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        final Group leftGroup = groupRepository.findByUuid(group1.getUuid()).get();
        assertThat(leftGroup.getMembers(), not(hasItem(user2.getUuid())));
    }

    @Test
    public void joining_group_joining_challenge_and_leaving_it() throws Exception {
        // requesting to join public group
        mockMvc.perform(get("/api/groups/" + group1.getUuid() + "/join?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        // requesting to join public challenge
        mockMvc.perform(get("/api/challenges/" + challenge1.getUuid() + "/join?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        final Challenge joinedChallenge = challengesRepository.findByUuid(challenge1.getUuid()).get();
        assertThat(joinedChallenge.getParticipants(), hasItem(user2.getUuid()));

        // leaving challenge
        mockMvc.perform(get("/api/challenges/" + challenge1.getUuid() + "/leave?userUuid=" + user2.getUuid()))
                .andExpect(status().isOk());

        final Challenge leftChallenge = challengesRepository.findByUuid(challenge1.getUuid()).get();
        assertThat(leftChallenge.getParticipants(), not(hasItem(user2.getUuid())));
    }

    @Test
    public void approving_join_request_and_then_removing_joined_user() {
        // create mock join request

        // approve join request
        // kick joined user from group
    }

    @Test
    public void requesting_token_and_submitting_it() {

    }
}
