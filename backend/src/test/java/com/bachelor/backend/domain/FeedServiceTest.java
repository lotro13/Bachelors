package com.bachelor.backend.domain;

import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.feed.*;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.group.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class FeedServiceTest {

    @Inject
    FeedService feedService;

    @Inject
    GroupRepository groupRepository;

    @Inject
    PostsRepository postsRepository;

    @Inject
    ChallengesRepository challengesRepository;

    @Inject
    CommentsRepository commentsRepository;

    @BeforeEach
    public void clearData() {
        groupRepository.clear();
        postsRepository.clear();
        challengesRepository.clear();
        commentsRepository.clear();
    }

    @Test
    public void user_should_get_posts_from_all_his_groups() {
        UUID userUuid = UUID.randomUUID();

        Group firstGroup = Group.initialize(userUuid, "mock", AccessType.PUBLIC);
        var firstGroupUuid = firstGroup.getUuid();
        groupRepository.save(firstGroup);
        Group secondGroup = Group.initialize(userUuid, "mock", AccessType.PUBLIC);
        var secondGroupUuid = secondGroup.getUuid();
        groupRepository.save(secondGroup);

        Post first = Post.initialize(userUuid, firstGroupUuid, "name", "someImage");
        postsRepository.save(first);
        Post second = Post.initialize(userUuid, firstGroupUuid, "name", "someImage");
        postsRepository.save(second);
        Post third = Post.initialize(userUuid, secondGroupUuid, "name", "someImage");
        postsRepository.save(third);

        List<Post> posts = feedService.getFullUserFeed(userUuid);
        assertThat(posts, hasSize(3));
    }

    @Test
    public void user_should_be_able_to_get_posts_from_specific_group() {
        UUID userUuid = UUID.randomUUID();

        Group firstGroup = Group.initialize(userUuid, "mock", AccessType.PUBLIC);
        var firstGroupUuid = firstGroup.getUuid();
        groupRepository.save(firstGroup);
        Group secondGroup = Group.initialize(userUuid, "mock", AccessType.PUBLIC);
        var secondGroupUuid = secondGroup.getUuid();
        groupRepository.save(secondGroup);

        Post first = Post.initialize(userUuid, firstGroupUuid, "name", "someImage");
        postsRepository.save(first);
        Post second = Post.initialize(userUuid, firstGroupUuid, "name", "someImage");
        postsRepository.save(second);
        Post third = Post.initialize(userUuid, secondGroupUuid, "name", "someImage");
        postsRepository.save(third);

        List<Post> posts = feedService.getGroupFeed(userUuid, secondGroupUuid);
        assertThat(posts, hasSize(1));
    }

    @Test
    public void user_should_be_able_to_get_posts_from_challenge() {
        UUID userUuid = UUID.randomUUID();
        UUID groupUuid = UUID.randomUUID();

        Challenge firstChallenge = Challenge.initialize(userUuid, groupUuid, "mock", "", LocalDateTime.now());
        challengesRepository.save(firstChallenge);
        Challenge secondChallenge = Challenge.initialize(userUuid, groupUuid, "mock", "", LocalDateTime.now());
        challengesRepository.save(secondChallenge);

        Post first = Post.initialize(userUuid, firstChallenge.getUuid(), "name", "someImage");
        postsRepository.save(first);
        Post second = Post.initialize(userUuid, firstChallenge.getUuid(), "name", "someImage");
        postsRepository.save(second);
        Post third = Post.initialize(userUuid, secondChallenge.getUuid(), "name", "someImage");
        postsRepository.save(third);

        List<Post> posts = feedService.getChallengeFeed(userUuid, firstChallenge.getUuid());
        assertThat(posts, hasSize(2));
    }

    @Test
    public void user_should_be_able_to_create_post_in_group() {
        final UUID userUuid = UUID.randomUUID();

        Group firstGroup = Group.initialize(userUuid, "mock", AccessType.PUBLIC);
        Post post = Post.initialize(userUuid, firstGroup.getUuid(), "name", "someImage");
        feedService.createNewPost(post);

        final List<Post> posts = postsRepository.findAll();
        assertThat(posts, hasSize(1));
    }

    @Test
    public void user_should_be_able_to_post_comment_under_the_post() {
        final UUID userUuid = UUID.randomUUID();
        final UUID groupUuid = UUID.randomUUID();

        Post post = Post.initialize(userUuid, groupUuid, "name", "someImage");
        postsRepository.save(post);
        feedService.postComment(userUuid, post.getUuid(), "Comment");
        List<Comment> savedComments = feedService.findTargetComments(post.getUuid());
        assertThat(savedComments, hasSize(1));
    }

    @Test
    public void user_should_be_able_to_post_comment_under_other_comments() {
        UUID userUuid = UUID.randomUUID();
        UUID postUuid = UUID.randomUUID();

        Comment firstComment = Comment.initialize(userUuid, postUuid, "Comment");
        commentsRepository.save(firstComment);

        feedService.postComment(userUuid, firstComment.getUuid(), "Comment1");
        feedService.postComment(userUuid, firstComment.getUuid(), "Comment2");

        List<Comment> savedComments = feedService.findTargetComments(firstComment.getUuid());
        assertThat(savedComments, hasSize(2));
    }

    @Test
    public void group_founder_should_be_able_to_create_group_post() {
        final UUID founderUuid = UUID.randomUUID();
        Group group = Group.initialize(founderUuid, "Name", AccessType.PRIVATE);

        groupRepository.save(group);

        feedService.createNewGroupPost(founderUuid, group.getUuid(), "Post", "Description", "Resource");
        List<Post> savedPosts = postsRepository.findAll();
        assertThat(savedPosts, hasSize(1));
    }
}
