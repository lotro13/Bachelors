package com.bachelor.backend.domain.challenge;

import com.bachelor.backend.domain.AccessType;
import com.bachelor.backend.domain.feed.Post;
import com.bachelor.backend.domain.feed.PostsRepository;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChallengesService {

    @Inject
    private GroupRepository groupRepository;
    @Inject
    private ChallengesRepository challengesRepository;
    @Inject
    private PostsRepository postsRepository;

    public void closeChallenge(UUID userUuid, UUID challengeUuid) {
        final var optionalChallenge = challengesRepository.findByUuid(challengeUuid);
        if (optionalChallenge.isPresent()) {
            final Challenge challenge = optionalChallenge.get();
            final LocalDateTime now = LocalDateTime.now();
            if (LocalDateTime.parse(challenge.getDeadline()).isAfter(now)
                    && userUuid.equals(challenge.getFounder())
                    && (
                    challenge.getStatus().equals(ChallengeStatus.STARTED)
                            || challenge.getStatus().equals(ChallengeStatus.IDLE)
            )
            ) {
                final Challenge newChallenge = challenge.copy()
                        .withStatus(ChallengeStatus.CLOSED);

                challengesRepository.save(newChallenge);
            }
        }
    }

    public void startChallenge(UUID userUuid, UUID challengeUuid) {
        final var optionalChallenge = challengesRepository.findByUuid(challengeUuid);
        if (optionalChallenge.isPresent()) {
            final Challenge challenge = optionalChallenge.get();
            final LocalDateTime now = LocalDateTime.now();
            if (LocalDateTime.parse(challenge.getDeadline()).isAfter(now)
                    && userUuid.equals(challenge.getFounder())
                    && challenge.getStatus().equals(ChallengeStatus.IDLE)
            ) {
                final Challenge newChallenge = challenge.copy()
                        .withStatus(ChallengeStatus.STARTED);

                challengesRepository.save(newChallenge);
            }
        }
    }

    public void createSimplePost(Post newPost) {
        postsRepository.save(newPost);
    }

    public void createRatedPost(Post newPost) {
        final UUID postAuthor = newPost.getAuthor();
        final UUID challengeUuid = newPost.getTarget();

        final var optionalChallenge = challengesRepository.findByUuid(challengeUuid);
        if (optionalChallenge.isPresent()) {
            int postScore = 1;
            final Challenge newChallenge = optionalChallenge.get()
                    .updateScoreboard(Map.of(postAuthor, postScore));

            challengesRepository.save(newChallenge);
            postsRepository.save(newPost);
        }
    }

    public void leaveChallenge(UUID userUuid, UUID challengeUuid) {
        final Optional<Challenge> optionalChallenge = challengesRepository.findByUuid(challengeUuid);
        if (optionalChallenge.isPresent()) {
            final Challenge challenge = optionalChallenge.get();
            if (challenge.getParticipants().contains(userUuid)) {
                Challenge newChallenge = challenge.removeParticipants(userUuid);
                challengesRepository.update(newChallenge);
            }
        }
    }

    public void joinChallenge(UUID userUuid, UUID challengeUuid) {
        final Optional<Challenge> optionalChallenge = challengesRepository.findByUuid(challengeUuid);
        if (optionalChallenge.isPresent()) {
            final Challenge challenge = optionalChallenge.get();

            final Group group = groupRepository.findByUuid(challenge.getGroup()).get();
            final boolean userIsParentGroupMember = group.getMembers().contains(userUuid);

            if (userIsParentGroupMember) {
                Challenge newChallenge = challenge.addParticipant(userUuid);
                challengesRepository.update(newChallenge);
            }
        }
    }
}
