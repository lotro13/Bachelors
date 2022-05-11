package com.bachelor.backend.domain;

import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengeStatus;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.feed.Post;
import com.bachelor.backend.domain.feed.PostsRepository;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import com.bachelor.backend.domain.group.GroupsService;
import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class GroupServiceTest {

    @Inject
    GroupsService groupsService;

    @Inject
    GroupRepository groupRepository;

    @Inject
    ChallengesRepository challengesRepository;

    @Inject
    UsersRepository usersRepository;

    @Inject
    PostsRepository postsRepository;

    @BeforeEach
    public void clearData() {
        groupRepository.clear();
        challengesRepository.clear();
        usersRepository.clear();
        postsRepository.clear();
    }

    @Test
    public void user_should_be_able_to_create_group() {
        Group group = Group.initialize(UUID.randomUUID(), "Name", AccessType.PUBLIC);
        groupsService.createNewGroup(group);

        var savedGroups = groupRepository.findAll();
        assertThat(savedGroups, hasSize(1));
    }

    @Test
    public void user_should_be_able_to_join_public_group() {
        User user = User.initialize( "mock@");
        final UUID userUuid = user.getUuid();
        Group group = Group.initialize(UUID.randomUUID(), "Name", AccessType.PUBLIC);

        usersRepository.save(user);
        groupRepository.save(group);
        groupsService.tryToJoinGroup(userUuid, group.getUuid());

        Group savedGroup = groupRepository.findByUuid(group.getUuid()).get();
        var members = savedGroup.getMembers();
        assertThat(members, hasItem(userUuid));
    }

    @Test
    public void user_should_be_able_to_request_join_the_private_group() {
        User user = User.initialize( "mock@");
        final UUID userUuid = user.getUuid();
        Group group = Group.initialize(UUID.randomUUID(), "Name", AccessType.PRIVATE);

        usersRepository.save(user);
        groupRepository.save(group);
        groupsService.tryToJoinGroup(userUuid, group.getUuid());

        Group savedGroup = groupRepository.findByUuid(group.getUuid()).get();
        var requests = savedGroup.getPendingRequests();
        assertThat(requests, hasItem(userUuid));
    }

    @Test
    public void private_group_founder_should_be_able_to_approve_join_request() {
        final UUID founderUuid = UUID.randomUUID();
        Group group = Group.initialize(founderUuid, "Name", AccessType.PRIVATE);

        groupRepository.save(group);

        final User mock = User.initialize("mocker@");
        groupsService.tryToJoinGroup(mock.getUuid(), group.getUuid());
        groupsService.approveJoinRequest(founderUuid, group.getUuid(), mock.getUuid());

        Group savedGroup = groupRepository.findByUuid(group.getUuid()).get();
        var members = savedGroup.getMembers();
        assertThat(members, hasItem(mock.getUuid()));

        var requests = savedGroup.getPendingRequests();
        assertThat(requests, hasSize(0));
    }

    @Test
    public void private_group_founder_should_be_able_to_decline_join_request() {
        User founder = User.initialize( "mock@");
        final UUID founderUuid = founder.getUuid();
        Group group = Group.initialize(founderUuid, "Name", AccessType.PRIVATE);

        usersRepository.save(founder);
        groupRepository.save(group);

        final User mock = User.initialize("mocker@");
        groupsService.tryToJoinGroup(mock.getUuid(), group.getUuid());
        groupsService.declineJoinRequest(founderUuid, group.getUuid(), mock.getUuid());

        Group savedGroup = groupRepository.findByUuid(group.getUuid()).get();
        var members = savedGroup.getMembers();
        assertThat(members, not(hasItem(mock.getUuid())));

        var requests = savedGroup.getPendingRequests();
        assertThat(requests, hasSize(0));
    }

    @Test
    public void group_member_should_be_able_to_get_list_of_active_group_challenges() {
        User founder = User.initialize("mock@");
        final UUID founderUuid = founder.getUuid();
        Group group = Group.initialize(founderUuid, "Name", AccessType.PRIVATE);
        groupRepository.save(group);
        Challenge challenge = Challenge.initialize(founderUuid, group.getUuid(), "name", "", LocalDateTime.now());
        groupsService.createNewChallenge(challenge);

        var availableChallenges = groupsService.getAvailableChallenges(founderUuid, group.getUuid());
        assertThat(availableChallenges, hasSize(1));
    }

    @Test
    public void challenge_should_be_able_to_be_finished() {
        User founder = User.initialize( "mock@");
        final UUID founderUuid = founder.getUuid();
        final UUID memberUuid = founder.getUuid();
        final UUID challengeUuid = UUID.randomUUID();

        Group group = Group.initialize(founderUuid, "Name", AccessType.PUBLIC)
                .addGroupMember(memberUuid);
        groupRepository.save(group);

        Challenge challenge = Challenge.create(challengeUuid, founderUuid, group.getUuid(), "name", "", LocalDateTime.now().minus(1, ChronoUnit.DAYS))
                .updateScoreboard(Map.of(founderUuid, 3))
                .copy().withStatus(ChallengeStatus.STARTED);
        challengesRepository.save(challenge);

        groupsService.finishChallenge(challengeUuid);
        final Challenge savedChallenge = challengesRepository.findByUuid(challengeUuid).get();
        assertThat(savedChallenge.getStatus(), equalTo(ChallengeStatus.FINISHED));
    }

    @Test
    public void after_challenge_was_finished_users_score_should_be_changed_in_group() {
        User founder = User.initialize( "mock@");
        final UUID founderUuid = founder.getUuid();
        final UUID memberUuid = founder.getUuid();
        final UUID groupUuid = UUID.randomUUID();
        final UUID challengeUuid = UUID.randomUUID();

        Group group = Group.create(groupUuid, founderUuid, "Name", AccessType.PUBLIC)
                .addGroupMember(memberUuid);
        groupRepository.save(group);

        Challenge challenge = Challenge.create(challengeUuid, founderUuid, groupUuid, "name", "", LocalDateTime.now().minus(1, ChronoUnit.DAYS))
                .updateScoreboard(Map.of(founderUuid, 3))
                .copy().withStatus(ChallengeStatus.STARTED);
        challengesRepository.save(challenge);

        groupsService.finishChallenge(challengeUuid);
        final Group savedGroup = groupRepository.findByUuid(groupUuid).get();
        final var scoreboard = savedGroup.getScoreboard();
        assertThat(scoreboard.get(founderUuid), equalTo(3));
    }
}
