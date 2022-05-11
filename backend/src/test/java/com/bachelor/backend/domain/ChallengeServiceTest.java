package com.bachelor.backend.domain;

import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengeStatus;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.challenge.ChallengesService;
import com.bachelor.backend.domain.feed.Post;
import com.bachelor.backend.domain.feed.PostsRepository;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import com.bachelor.backend.domain.users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class ChallengeServiceTest {

    @Inject
    ChallengesService challengesService;

    @Inject
    ChallengesRepository challengesRepository;
    @Inject
    GroupRepository groupRepository;
    @Inject
    PostsRepository postsRepository;

    @BeforeEach
    public void clearData() {
        groupRepository.clear();
        challengesRepository.clear();
        postsRepository.clear();
    }

    @Test
    public void challenge_creator_should_be_able_to_start_challenges() {
        final UUID founderUuid = UUID.randomUUID();
        final UUID challengeUuid = UUID.randomUUID();
        final Challenge challenge = Challenge.create(challengeUuid, founderUuid, UUID.randomUUID(), "first", "", LocalDateTime.now().plus(1, ChronoUnit.DAYS));
        challengesRepository.save(challenge);
        challengesService.startChallenge(founderUuid, challengeUuid);

        final Challenge savedChallenge = challengesRepository.findByUuid(challengeUuid).get();
        assertThat(savedChallenge.getStatus(), equalTo(ChallengeStatus.STARTED));
    }

    @Test
    public void user_should_be_able_to_create_post_in_challenge() {
        final UUID postUuid = UUID.randomUUID();
        final UUID challengeUuid = UUID.randomUUID();
        final Challenge challenge = Challenge.create(challengeUuid, UUID.randomUUID(), UUID.randomUUID(), "first", "", LocalDateTime.now().plus(1, ChronoUnit.DAYS));
        challengesRepository.save(challenge);
        Post newPost = Post.create(postUuid, UUID.randomUUID(), challengeUuid, "title", "description", "image", 0);
        challengesService.createSimplePost(newPost);

        final var savedPosts = postsRepository.findByTarget(challengeUuid);
        assertThat(savedPosts, hasSize(1));
    }

    @Test
    public void user_should_be_able_to_post_task_completion_in_challenge() {
        final UUID postUuid = UUID.randomUUID();
        final UUID challengeUuid = UUID.randomUUID();
        final Challenge challenge = Challenge.create(challengeUuid, UUID.randomUUID(), UUID.randomUUID(), "first", "", LocalDateTime.now().plus(1, ChronoUnit.DAYS));
        challengesRepository.save(challenge);
        Post newPost = Post.create(postUuid, UUID.randomUUID(), challengeUuid, "title", "description", "image", 0);
        challengesService.createRatedPost(newPost);

        final var savedPosts = postsRepository.findByTarget(challengeUuid);
        assertThat(savedPosts, hasSize(1));
    }

    @Test
    public void after_user_completed_a_task_in_challenge_he_should_receive_points_in_challenge() {
        final UUID userUuid = UUID.randomUUID();
        final UUID postUuid = UUID.randomUUID();
        final UUID challengeUuid = UUID.randomUUID();
        final Challenge challenge = Challenge.create(challengeUuid, userUuid, UUID.randomUUID(), "first", "", LocalDateTime.now().plus(1, ChronoUnit.DAYS));
        challengesRepository.save(challenge);

        Post newPost = Post.create(postUuid, userUuid, challengeUuid, "title", "description", "image", 0);
        challengesService.createRatedPost(newPost);

        final Challenge savedChallenge = challengesRepository.findByUuid(challengeUuid).get();
        final Integer userScore = savedChallenge.getScoreboard().get(userUuid);
        assertThat(userScore, not(equalTo(0)));
    }

    @Test
    public void challenge_should_be_able_to_be_started() {
        User founder = User.initialize("mock@");
        final UUID founderUuid = founder.getUuid();
        final UUID challengeUuid = UUID.randomUUID();

        Challenge challenge = Challenge.create(challengeUuid, founderUuid, UUID.randomUUID(), "name", "", LocalDateTime.now().minus(1, ChronoUnit.DAYS))
                .updateScoreboard(Map.of(founderUuid, 3))
                .copy().withStatus(ChallengeStatus.STARTED);
        challengesRepository.save(challenge);

        challengesService.startChallenge(founderUuid, challengeUuid);
        final Challenge savedChallenge = challengesRepository.findByUuid(challengeUuid).get();
        assertThat(savedChallenge.getStatus(), equalTo(ChallengeStatus.STARTED));
    }

    @Test
    public void challenge_founder_should_be_able_to_close_challenge() {
        User founder = User.initialize("mock@");
        final UUID founderUuid = founder.getUuid();
        final UUID challengeUuid = UUID.randomUUID();

        Challenge challenge = Challenge.create(challengeUuid, founderUuid, UUID.randomUUID(), "name", "", LocalDateTime.now().plus(1, ChronoUnit.DAYS))
                .updateScoreboard(Map.of(founderUuid, 3));
        challengesRepository.save(challenge);

        challengesService.closeChallenge(founderUuid, challengeUuid);
        final Challenge savedChallenge = challengesRepository.findByUuid(challengeUuid).get();
        assertThat(savedChallenge.getStatus(), equalTo(ChallengeStatus.CLOSED));
    }

    @Test
    public void group_member_should_be_able_to_join_active_group_challenge() {
        User founder = User.initialize("mock@");
        final UUID founderUuid = founder.getUuid();
        final UUID newUserUuid = UUID.randomUUID();

        Group group = Group.initialize(founderUuid, "Name", AccessType.PUBLIC)
                .addGroupMember(newUserUuid);
        groupRepository.save(group);

        Challenge challenge = Challenge.initialize(founderUuid, group.getUuid(), "name", "", LocalDateTime.now());
        challengesRepository.save(challenge);

        challengesService.joinChallenge(newUserUuid, challenge.getUuid());

        Challenge savedChallenge = challengesRepository.findByUuid(challenge.getUuid()).get();
        assertThat(savedChallenge.getParticipants(), hasItem(newUserUuid));
    }

    @Test
    public void group_member_should_be_able_to_leave_challenge() {
        User founder = User.initialize("mock@");
        final UUID founderUuid = founder.getUuid();
        final UUID groupUuid = UUID.randomUUID();

        Challenge challenge = Challenge.initialize(founderUuid, groupUuid, "name", "", LocalDateTime.now());
        challengesRepository.save(challenge);

        final User mock = User.initialize("mocker@");
        challengesService.leaveChallenge(mock.getUuid(), challenge.getUuid());

        Challenge savedChallenge = challengesRepository.findByUuid(challenge.getUuid()).get();
        assertThat(savedChallenge.getParticipants(), not(hasItem(mock.getUuid())));
    }
}
