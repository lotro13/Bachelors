package com.bachelor.backend.api;

import com.bachelor.backend.domain.authentication.TokenRepository;
import com.bachelor.backend.domain.challenge.*;
import com.bachelor.backend.domain.feed.*;
import com.bachelor.backend.domain.group.*;
import com.bachelor.backend.domain.users.ImmutableUserPage;
import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UserPage;
import com.bachelor.backend.domain.users.UsersRepository;
import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.bachelor.backend.MockData.*;

@RestController
public class ApiController {

    @Inject
    private FeedService feedService;
    @Inject
    private GroupRepository groupRepository;
    @Inject
    private ChallengesRepository challengesRepository;
    @Inject
    private UsersRepository usersRepository;
    @Inject
    private PostsRepository postsRepository;
    @Inject
    private CommentsRepository commentsRepository;
    @Inject
    private TokenRepository tokenRepository;
    @Inject
    private GroupsService groupsService;
    @Inject
    private ChallengesService challengesService;
    @Inject
    private Gson gson;

    @GetMapping(value = "/api/init")
    public String initData() {
        usersRepository.saveAll(USERS);
        groupRepository.saveAll(GROUPS);
        challengesRepository.saveAll(CHALLENGES);
        postsRepository.saveAll(POSTS);
        commentsRepository.saveAll(COMMENTS);
        tokenRepository.save(TOKENS);

        return "Initiation finished";
    }

    //================================================= Feed ===========================================================

    @GetMapping(value = "/api/feed")
    public String getUserFeed(
            Principal principal,
            @RequestParam(value = "groupUuid", required = false) UUID groupUuid,
            @RequestParam(value = "challengeUuid", required = false) UUID challengeUuid
    ) {
        if (principal != null) {
            final UUID userUuid = getUserUuidFromEmail(principal.getName());
            List<Post> posts;

            if (groupUuid != null) {
                posts = feedService.getGroupFeed(userUuid, groupUuid);
            } else if (challengeUuid != null) {
                posts = feedService.getChallengeFeed(userUuid, challengeUuid);
            } else {
                posts = feedService.getFullUserFeed(userUuid);
            }

            return gson.toJson(posts.stream().map(p -> toPostPage(p)).collect(Collectors.toList()));
        }

        return "[]";
    }

    @PostMapping(
            value = "/api/feed/posts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createNewPost(@RequestBody NewPost newPost) {
        final Post post = Post.create(newPost);
        feedService.createNewPost(post);

        return ResponseEntity.ok("Post created");
    }

    @GetMapping(value = "/api/feed/{postUuid}")
    public ResponseEntity<String> getPostByUuid(@PathVariable UUID postUuid) {
        final var optionalPost = postsRepository.findByUuid(postUuid);

        if (optionalPost.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        final Post post = optionalPost.get();

        return ResponseEntity.ok(gson.toJson(toPostPage(post)));
    }

    @GetMapping(value = "/api/feed/{postUuid}/comments")
    public ResponseEntity<String> getTargetComments(@PathVariable UUID postUuid) {
        final var postComments = feedService.findTargetComments(postUuid).stream()
                .map(c -> c.copy().withAuthor(usersRepository.findByUuid(c.getAuthorUuid()).get().getUsername()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(gson.toJson(postComments));
    }

    @PostMapping(
            value = "/api/feed/comments",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createNewComment(@RequestBody NewComment comment) {
        feedService.postComment(Comment.create(comment));

        return ResponseEntity.ok("Comment created");
    }

    //==================================================================================================================

    @GetMapping(value = "/api/groups")
    public String getUseGroups(@RequestParam(value = "uuid", required = false) UUID uuid, Principal principal) {

        final UUID userUuid = getUserUuidFromEmail(principal.getName());

        if (uuid != null) {
            var groups = groupRepository.finUserGroups(uuid).stream()
                    .map(g -> toGroupPage(userUuid, g))
                    .collect(Collectors.toList());
            return gson.toJson(groups);
        }

        var groups = groupRepository.findAll().stream()
                .map(g -> toGroupPage(userUuid, g))
                .collect(Collectors.toList());
        return gson.toJson(groups);
    }

    @GetMapping(value = "/api/groups/{groupUuid}")
    public ResponseEntity<String> getGroup(@PathVariable UUID groupUuid, Principal principal) {
        final var user = usersRepository.findByEmail(principal.getName()).get();
        final var optionalGroup = groupRepository.findByUuid(groupUuid);

        if (optionalGroup.isEmpty()) {
            return ResponseEntity.notFound()
                    .build();
        }

        return ResponseEntity.ok(gson.toJson(toGroupPage(user.getUuid(), optionalGroup.get())));
    }

    @PostMapping(
            value = "/api/groups/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createNewGroup(@RequestBody NewGroup newGroup) {
        Group group = Group.create(newGroup);
        groupsService.createNewGroup(group);

        return ResponseEntity.ok("New group created");
    }

    @GetMapping(value = "/api/groups/{groupUuid}/challenges")
    public ResponseEntity<String> getGroupChallenges(@PathVariable UUID groupUuid, Principal principal) {
        final var user = usersRepository.findByEmail(principal.getName()).get();
        final var groupChallenges = challengesRepository.findByGroup(groupUuid).stream()
                .map(c -> toChallengePage(user.getUuid(), c))
                .collect(Collectors.toList());
        return ResponseEntity.ok(gson.toJson(groupChallenges));
    }

    @GetMapping(value = "/api/groups/{groupUuid}/feed")
    public ResponseEntity<String> getGroupFeed(
            @PathVariable UUID groupUuid,
            @RequestParam(value = "userUuid") UUID userUuid
    ) {
        final var feed = feedService.getGroupFeed(userUuid, groupUuid).stream()
                .map(this::toPostPage)
                .collect(Collectors.toList());
        return ResponseEntity.ok(gson.toJson(feed));
    }

    @GetMapping(value = "/api/groups/{groupUuid}/join")
    public ResponseEntity<String> requestToJoinGroup(
            @PathVariable UUID groupUuid,
            @RequestParam(value = "userUuid") UUID uuid
    ) {
        groupsService.tryToJoinGroup(uuid, groupUuid);
        return ResponseEntity.ok("Joined");
    }

    @GetMapping(value = "/api/groups/{groupUuid}/leave")
    public ResponseEntity<String> leaveGroup(
            @PathVariable UUID groupUuid,
            @RequestParam(value = "userUuid") UUID uuid
    ) {
        groupsService.leaveGroup(uuid, groupUuid);
        return ResponseEntity.ok("Joined");
    }

    //==================================================================================================================

    @GetMapping(value = "/api/challenges/{challengeUuid}")
    public ResponseEntity<String> getChallenge(@PathVariable UUID challengeUuid, Principal principal) {
        final var user = usersRepository.findByEmail(principal.getName()).get();
        var challenge = challengesRepository.findByUuid(challengeUuid);

        if (challenge.isEmpty()) {
            return ResponseEntity.notFound()
                    .build();
        }

        return ResponseEntity.ok(gson.toJson(toChallengePage(user.getUuid(), challenge.get())));
    }

    @GetMapping(value = "/api/challenges/{challengeUuid}/feed")
    public ResponseEntity<String> getChallengeFeed(
            @PathVariable UUID challengeUuid
    ) {
        final var feed = feedService.getChallengeFeed(firstUser, challengeUuid).stream()
                .map(this::toPostPage)
                .collect(Collectors.toList());
        ;
        return ResponseEntity.ok(gson.toJson(feed));
    }

    @GetMapping(value = "/api/challenges/active")
    public String getActiveUserChallenges(Principal principal) {
        final var user = usersRepository.findByEmail(principal.getName()).get();
        var challenges = challengesRepository.findAll().stream()
                .filter(c -> c.getStatus().equals(ChallengeStatus.STARTED) && c.getParticipants().contains(user.getUuid()))
                .map(c -> toChallengePage(user.getUuid(), c))
                .collect(Collectors.toList());
        return gson.toJson(challenges);
    }

    @GetMapping(value = "/api/challenges")
    public String getUserChallenges(
            @RequestParam(value = "userUuid", required = false) UUID userUuid,
            @RequestParam(value = "groupUuid", required = false) UUID groupUuid,
            Principal principal
    ) {
        final var user = usersRepository.findByEmail(principal.getName()).get();
        List<Challenge> challenges;
        if (groupUuid != null) {
            challenges = challengesRepository.findUserChallengesInGroup(userUuid, groupUuid);
            return gson.toJson(challenges);
        } else if (userUuid != null) {
            challenges = challengesRepository.findUserChallenges(userUuid);
            return gson.toJson(challenges);
        } else {
            challenges = challengesRepository.findAll();
        }

        return gson.toJson(challenges.stream().map(c -> toChallengePage(userUuid, c)).collect(Collectors.toList()));
    }

    @PostMapping(
            value = "/api/challenges/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> createNewChallenge(@RequestBody NewChallenge newChallenge) {
        final Challenge challenge = Challenge.create(newChallenge);
        final boolean wasInserted = groupsService.createNewChallenge(challenge);
        if (wasInserted) {
            return ResponseEntity.ok("New challenge created");
        }

        return ResponseEntity
                .badRequest()
                .build();
    }

    @GetMapping(value = "/api/challenges/{challengeUuid}/start")
    public ResponseEntity<String> startChallenge(
            Principal principal,
            @PathVariable UUID challengeUuid
    ) {
        final UUID userUuid = getUserUuidFromEmail(principal.getName());
        challengesService.startChallenge(userUuid, challengeUuid);

        return ResponseEntity.ok("Challenge stopped");
    }

    @GetMapping(value = "/api/challenges/{challengeUuid}/close")
    public ResponseEntity<String> closeChallenge(
            Principal principal,
            @PathVariable UUID challengeUuid
    ) {
        final UUID userUuid = getUserUuidFromEmail(principal.getName());
        challengesService.closeChallenge(userUuid, challengeUuid);

        return ResponseEntity.ok("Challenge stopped");
    }

    @PostMapping(
            value = "/api/challenges/createRatedPost",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> createRatedChallengePost(
            @RequestBody NewPost newPost
    ) {
        final Post post = Post.create(newPost);
        challengesService.createRatedPost(post);
        return ResponseEntity.ok("Rated challenge post created");
    }

    @GetMapping(value = "/api/challenges/{challengeUuid}/join")
    public ResponseEntity<String> requestToJoinChallenge(
            @PathVariable UUID challengeUuid,
            @RequestParam(value = "userUuid") UUID uuid
    ) {
        challengesService.joinChallenge(uuid, challengeUuid);
        return ResponseEntity.ok("User joined challenged");
    }

    @GetMapping(value = "/api/challenges/{challengeUuid}/leave")
    public ResponseEntity<String> leaveChallenge(
            @PathVariable UUID challengeUuid,
            @RequestParam(value = "userUuid") UUID uuid
    ) {
        challengesService.leaveChallenge(uuid, challengeUuid);
        return ResponseEntity.ok("User left challenge");
    }

    //==================================================================================================================

    @GetMapping(value = "/api/users")
    public ResponseEntity<String> getUser(@RequestParam(value = "uuid", required = false) UUID uuid) {
        if (uuid != null) {
            var user = usersRepository.findByUuid(uuid);
            return user.map(value -> ResponseEntity
                            .ok(gson.toJson(value)))
                    .orElseGet(() -> ResponseEntity
                            .notFound()
                            .build()
                    );
        }

        final List<User> users = usersRepository.findAll();
        return ResponseEntity.ok(gson.toJson(users));
    }

    private UUID getUserUuidFromEmail(String email) {
        final var user = usersRepository.findByEmail(email).get();
        return user.getUuid();
    }

    private PostPage toPostPage(Post post) {
        final User author = usersRepository.findByUuid(post.getAuthor()).get();
        final int numberOfComments = commentsRepository.findByTarget(post.getUuid()).size();

        return ImmutablePostPage.builder()
                .uuid(post.getUuid())
                .authorName(author.getUsername())
                .title(post.getTitle())
                .description(post.getDescription())
                .bodyURL(post.getBodyURL())
                .numberOfComments(numberOfComments)
                .build();
    }

    private ChallengePage toChallengePage(UUID userUuid, Challenge challenge) {

        final var scoreboard = challenge.getScoreboard().entrySet().stream()
                .collect(Collectors.toMap(k -> usersRepository.findByUuid(k.getKey()).get().getUsername(), Map.Entry::getValue));

        return ImmutableChallengePage.builder()
                .uuid(challenge.getUuid())
                .name(challenge.getName())
                .description(challenge.getDescription())
                .deadline(challenge.getDeadline())
                .status(challenge.getStatus())
                .canManageStatus(userUuid.equals(challenge.getFounder()))
                .canCreatePost(challenge.getStatus().equals(ChallengeStatus.STARTED) && challenge.getParticipants().contains(userUuid))
                .scoreboard(scoreboard)
                .type(challenge.getType())
                .canCreateRatedPost(true) ///TODO implement rated posts
                .build();
    }

    private GroupPage toGroupPage(UUID userUuid, Group group) {
        boolean idFounder = group.getFounder().equals(userUuid);
        boolean isModerator = group.getModerators().contains(userUuid);

        final var groupMembers = group.getMembers().stream()
                .map(uuid -> usersRepository.findByUuid(uuid).get())
                .map(u -> UserPage.create(u))
                .collect(Collectors.toList());

        final var pendingRequests = group.getMembers().stream()
                .map(uuid -> usersRepository.findByUuid(uuid).get())
                .map(u -> UserPage.create(u))
                .collect(Collectors.toList());


        final var scoreboard = group.getScoreboard().entrySet().stream()
                .collect(Collectors.toMap(k -> usersRepository.findByUuid(k.getKey()).get().getUsername(), Map.Entry::getValue));

        return ImmutableGroupPage.builder()
                .uuid(group.getUuid())
                .accessType(group.getAccessType())
                .name(group.getName())
                .members(groupMembers)
                .canCreateChallenge(idFounder)
                .canManageUsers(isModerator || idFounder)
                .pendingRequests(pendingRequests)
                .scoreboard(scoreboard)
                .build();
    }

    private UserPage toUserPage(User user) {
        return ImmutableUserPage.builder()
                .uuid(user.getUuid())
                .username(user.getUsername())
                .build();
    }
}
