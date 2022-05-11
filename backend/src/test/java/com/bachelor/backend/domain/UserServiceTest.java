package com.bachelor.backend.domain;

import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UsersRepository;
import com.bachelor.backend.domain.users.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class UserServiceTest {

    @Inject
    public UsersRepository usersRepository;

    @Inject
    public GroupRepository groupRepository;

    @Inject
    public ChallengesRepository challengesRepository;

    @Inject
    public UsersService usersService;

    @BeforeEach
    public void clearData() {
        usersRepository.clear();
        groupRepository.clear();
        challengesRepository.clear();
        usersRepository.clear();
    }

    @Test
    public void user_should_be_able_to_get_all_his_groups() {
        User user = User.initialize("mock@");
        final UUID userUuid = user.getUuid();
        usersRepository.save(user);

        Group first = Group.initialize(userUuid, "first", AccessType.PUBLIC);
        groupRepository.save(first);
        Group second = Group.initialize(userUuid, "second", AccessType.PUBLIC);
        groupRepository.save(second);
        Group third = Group.initialize(userUuid, "third", AccessType.PUBLIC);
        groupRepository.save(third);


        var usersGroups = usersService.getUserOwnedGroups(userUuid);
        assertThat(usersGroups, hasSize(3));
    }

    @Test
    public void user_should_be_able_to_get_all_his_challenges() {
        User user = User.initialize("mock@");
        final UUID userUuid = user.getUuid();
        usersRepository.save(user);

        Group mock = Group.initialize(userUuid, "first", AccessType.PUBLIC);
        groupRepository.save(mock);

        Challenge first = Challenge.initialize(userUuid, mock.getUuid(), "first", "", LocalDateTime.now());
        challengesRepository.save(first);
        Challenge second = Challenge.initialize(userUuid, mock.getUuid(), "second", "", LocalDateTime.now());
        challengesRepository.save(second);
        Challenge third = Challenge.initialize(userUuid, mock.getUuid(), "third", "", LocalDateTime.now());
        challengesRepository.save(third);

        var userChallenges = usersService.getUserOwnedChallenges(userUuid, Optional.empty());
        assertThat(userChallenges, hasSize(3));
    }

}
