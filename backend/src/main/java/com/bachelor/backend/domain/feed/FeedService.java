package com.bachelor.backend.domain.feed;

import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FeedService {

    @Inject
    private GroupRepository groupRepository;
    @Inject
    private ChallengesRepository challengesRepository;
    @Inject
    private PostsRepository postsRepository;
    @Inject
    private CommentsRepository commentsRepository;

    public List<Post> getFullUserFeed(UUID userUuid) {
        var userGroups = groupRepository.finUserGroups(userUuid).stream()
                .map(Group::getUuid);
        var userChallenges = challengesRepository.findUserChallenges(userUuid).stream()
                .map(Challenge::getUuid);

        return Stream.concat(userGroups, userChallenges)
                .flatMap(uuid -> postsRepository.findByTarget(uuid).stream())
                .collect(Collectors.toList());
    }

    public List<Post> getGroupFeed(UUID userUuid, UUID groupUuid) {
        return groupRepository.finUserGroups(userUuid).stream()
                .map(Group::getUuid)
                .filter(uuid -> uuid.equals(groupUuid))
                .flatMap(uuid -> postsRepository.findByTarget(uuid).stream())
                .collect(Collectors.toList());
    }

    public List<Post> getChallengeFeed(UUID userUuid, UUID challengeUuid) {
        return challengesRepository.findUserChallenges(userUuid).stream()
                .map(Challenge::getUuid)
                .filter(uuid -> uuid.equals(challengeUuid))
                .flatMap(uuid -> postsRepository.findByTarget(uuid).stream())
                .collect(Collectors.toList());
    }

    public void createNewGroupPost(UUID founderUuid, UUID uuid, String title, String description, String resource) {
        Post post = Post.initialize(founderUuid, uuid, title, description, resource);
        postsRepository.save(post);
    }

    public void createNewPost(Post post) {
        postsRepository.save(post);
    }

    public void postComment(UUID userUuid, UUID target, String comment) {
        final Comment newComment = Comment.initialize(userUuid, target, comment);
        postComment(newComment);
    }

    public void postComment(Comment newComment) {
        commentsRepository.save(newComment);
        postsRepository.addCommentToPost(newComment.getTargetUuid());
    }

    public List<Comment> findTargetComments(UUID uuid) {
        return commentsRepository.findByTarget(uuid);
    }
}
