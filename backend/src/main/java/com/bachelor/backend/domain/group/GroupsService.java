package com.bachelor.backend.domain.group;

import com.bachelor.backend.domain.AccessType;
import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengeStatus;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.feed.Post;
import com.bachelor.backend.domain.feed.PostsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupsService {

    @Inject
    private GroupRepository groupRepository;
    @Inject
    private ChallengesRepository challengesRepository;

    public void createNewGroup(Group group) {
        groupRepository.save(group);
    }

    public void tryToJoinGroup(UUID userUuid, UUID groupUuid) {
        final Optional<Group> optionalGroup = groupRepository.findByUuid(groupUuid);
        if (optionalGroup.isPresent()) {
            final Group group = optionalGroup.get();
            if (group.getAccessType().equals(AccessType.PUBLIC)
                    || group.getPendingRequests().contains(userUuid)) {
                Group updatedGroup = group.addGroupMember(userUuid);
                groupRepository.update(updatedGroup);
            } else if (group.getAccessType().equals(AccessType.PRIVATE)) {
                final Group updatedGroup = group.addUserJoinRequest(userUuid);
                groupRepository.update(updatedGroup);
            }
        }
    }

    public void leaveGroup(UUID userUuid, UUID groupUuid) {
        final var optionalGroup = groupRepository.findByUuid(groupUuid);
        if (optionalGroup.isPresent()) {
            final Group group = optionalGroup.get();
            if (group.getMembers().contains(userUuid)) {
                Group newGroup = group.removeMember(userUuid);
                groupRepository.update(newGroup);
            }
        }
    }

    public void approveJoinRequest(UUID founderUuid, UUID groupUuid, UUID targetUuid) {
        final Optional<Group> optionalGroup = groupRepository.findByUuid(groupUuid);
        if (optionalGroup.isPresent()) {
            final Group group = optionalGroup.get();
            if (group.getFounder().equals(founderUuid)
                    && group.getPendingRequests().contains(targetUuid)) {
                Group updatedGroup = group.addGroupMember(targetUuid);
                groupRepository.update(updatedGroup);
            }
        }
    }

    public void declineJoinRequest(UUID founderUuid, UUID groupUuid, UUID targetUuid) {
        final Optional<Group> optionalGroup = groupRepository.findByUuid(groupUuid);
        if (optionalGroup.isPresent()) {
            final Group group = optionalGroup.get();
            if (group.getFounder().equals(founderUuid)
                    && group.getPendingRequests().contains(targetUuid)) {
                Group updatedGroup = group.declineJoinRequest(targetUuid);
                groupRepository.update(updatedGroup);
            }
        }
    }

    public boolean createNewChallenge(Challenge challenge) {
        final UUID groupUuid = challenge.getGroup();
        final UUID founderUuid = challenge.getFounder();
        final Optional<Group> optionalGroup = groupRepository.findByUuid(groupUuid);
        if (optionalGroup.isPresent()) {
            final Group group = optionalGroup.get();
            if (group.getFounder().equals(founderUuid)) {
                try {
                    challengesRepository.save(challenge);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    public List<Challenge> getAvailableChallenges(UUID userUuid, UUID groupUuid) {
        var groupChallenges = challengesRepository.findByGroup(groupUuid);
        return groupChallenges.stream()
                .filter(c -> c.getParticipants().contains(userUuid))
                .collect(Collectors.toList());
    }

    public void finishChallenge(UUID challengeUuid) {
        final var optionalChallenge = challengesRepository.findByUuid(challengeUuid);
        if (optionalChallenge.isPresent()) {
            final Challenge challenge = optionalChallenge.get();
            final LocalDateTime now = LocalDateTime.now();
            if (LocalDateTime.parse(challenge.getDeadline()).isBefore(now)
                    && challenge.getStatus().equals(ChallengeStatus.STARTED)) {
                final Challenge newChallenge = challenge.copy()
                        .withStatus(ChallengeStatus.FINISHED);
                challengesRepository.save(newChallenge);

                final UUID groupUuid = challenge.getGroup();
                final Group group = groupRepository.findByUuid(groupUuid).get()
                        .updateScoreBoard(challenge.getScoreboard());
                groupRepository.update(group);
            }
        }
    }
}
