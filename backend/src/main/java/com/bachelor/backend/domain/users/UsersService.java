package com.bachelor.backend.domain.users;

import com.bachelor.backend.domain.authentication.TokenRepository;
import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsersService {

    @Inject
    private GroupRepository groupRepository;
    @Inject
    private ChallengesRepository challengesRepository;
    @Inject
    private TokenRepository tokenRepository;

    public List<Group> getUserOwnedGroups(UUID userUuid) {
        return groupRepository.findByFounder(userUuid);
    }

    public List<Challenge> getUserOwnedChallenges(UUID userUuid, Optional<UUID> groupUuid) {
        return challengesRepository.findByFounder(userUuid)
                .stream()
                .filter(c -> groupUuid.map(uuid -> c.getGroup().equals(uuid)).orElse(true))
                .collect(Collectors.toList());
    }

    public boolean isTokenValid(String email, String token) {
        return tokenRepository.isTokenValid(email, token);
    }
}
