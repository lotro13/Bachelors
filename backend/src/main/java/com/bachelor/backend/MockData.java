package com.bachelor.backend;

import com.bachelor.backend.domain.AccessType;
import com.bachelor.backend.domain.challenge.Challenge;
import com.bachelor.backend.domain.challenge.ChallengeStatus;
import com.bachelor.backend.domain.feed.Comment;
import com.bachelor.backend.domain.feed.Post;
import com.bachelor.backend.domain.group.Group;
import com.bachelor.backend.domain.users.User;
import com.bachelor.backend.domain.users.UserRegistrationStatus;
import com.bachelor.backend.domain.users.UserValidationToken;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MockData {
    public static final UUID firstUser = UUID.randomUUID();
    private static final UUID secondUser = UUID.randomUUID();
    private static final UUID thirdUser = UUID.randomUUID();

    private static final UUID firstGroup = UUID.randomUUID();
    private static final UUID secondGroup = UUID.randomUUID();
    private static final UUID thirdGroup = UUID.randomUUID();

    private static final UUID firstChallenge = UUID.randomUUID();
    private static final UUID secondChallenge = UUID.randomUUID();
    private static final UUID thirdChallenge = UUID.randomUUID();
    private static final UUID fourthChallenge = UUID.randomUUID();
    private static final UUID fifthChallenge = UUID.randomUUID();

    private static final UUID firstPost = UUID.randomUUID();
    private static final UUID secondPost = UUID.randomUUID();
    private static final UUID thirdPost = UUID.randomUUID();
    private static final UUID fourthPost = UUID.randomUUID();
    private static final UUID fifthPost = UUID.randomUUID();
    private static final UUID sixthPost = UUID.randomUUID();
    private static final UUID seventhPost = UUID.randomUUID();
    private static final UUID eightPost = UUID.randomUUID();

    private static final UUID firstComment = UUID.randomUUID();
    private static final UUID secondComment = UUID.randomUUID();
    private static final UUID thirdComment = UUID.randomUUID();
    private static final UUID fourthComment = UUID.randomUUID();
    private static final UUID fifthComment = UUID.randomUUID();
    private static final UUID sixthComment = UUID.randomUUID();
    private static final UUID seventhComment = UUID.randomUUID();
    private static final UUID eightComment = UUID.randomUUID();
    private static final UUID ninthComment = UUID.randomUUID();
    private static final UUID tenthComment = UUID.randomUUID();

    public static List<User> USERS = List.of(
            User.create(firstUser, "first@mock", "Andrej", Instant.now(), UserRegistrationStatus.VALIDATED),
            User.create(secondUser, "second@mock", "Jonas", Instant.now(), UserRegistrationStatus.VALIDATED),
            User.create(thirdUser, "third@mock", "Jhon", Instant.now(), UserRegistrationStatus.VALIDATED)
    );

    public static UserValidationToken TOKENS = UserValidationToken.createCustom("first@mock", "lotro");

    public static List<Group> GROUPS = List.of(
            Group.create(firstGroup, firstUser, "Healthy lifestyle", AccessType.PUBLIC),
            Group.create(secondGroup, firstUser, "Jogging team", AccessType.PRIVATE),
            Group.create(thirdGroup, secondUser, "Virtus Pro", AccessType.PUBLIC)
    );

    public static List<Challenge> CHALLENGES = List.of(
            Challenge.create(firstChallenge, firstUser, firstGroup, "Daily walking", "Walk 10,000 steps each day", LocalDateTime.now()).copy().withStatus(ChallengeStatus.STARTED),
            Challenge.create(secondChallenge, firstUser, firstGroup, "Hydration", "Each day drink 1.5L", LocalDateTime.now()).addParticipant(thirdUser),
            Challenge.create(thirdChallenge, firstUser, secondGroup, "Marathon", "Run a marathon", LocalDateTime.now()),
            Challenge.create(fourthChallenge, secondUser, thirdGroup, "In shape", "Run 3 times per week", LocalDateTime.now()),
            Challenge.create(fifthChallenge, secondUser, thirdGroup, "Gathering", "Attend group meeting on Fridays", LocalDateTime.now())
    );

    public static List<Post> POSTS = List.of(
            Post.create(firstPost, firstUser, firstGroup, "Marathon announcement", "Next marathon", "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fbennysjolind.com%2Fwp-content%2Fuploads%2F2014%2F01%2Fvilnius-marathon.jpg&f=1&nofb=1", 0),
            Post.create(secondPost, firstUser, firstChallenge, "New tracker", "I have bought myself new step tracker", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmedia.istockphoto.com%2Fphotos%2Fsmart-watch-on-the-boys-hand-picture-id885350126%3Fk%3D6%26m%3D885350126%26s%3D170667a%26w%3D0%26h%3DybjV9bDJas81IlGigRJMJa_X8k88i7YQK-SXbyaN2Qo%3D&f=1&nofb=1", 0),
            Post.create(thirdPost, thirdUser, thirdChallenge, "I did it", "I have just run my first marathon", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.easytourchina.com%2Fimages%2FPhoto%2Fguilin-international-marathon%2Fp323_d20171127153159.jpg&f=1&nofb=1", 0),
            Post.create(fourthPost, firstUser, secondChallenge, "Halfway done", "", "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.mnI23746ma3_3vrHQkZNjgHaHa%26pid%3DApi&f=1", 0),
            Post.create(fifthPost, firstUser, thirdChallenge, "Almost", ":(", "https://media.istockphoto.com/photos/exhaustion-after-the-race-picture-id139862046?k=20&m=139862046&s=612x612&w=0&h=cXhtgsQOe7uEjvfGDE4HWTYetopUtwc0t8yEi_i4Js0=", 0),
            Post.create(sixthPost, secondUser, fourthChallenge, "New gym", "", "https://www.californiafamilyfitness.com/hubfs/2021/2021%20Indoor%20Gym%20Page%20Photos/RSV/Rosevillle_Freeweights.jpg", 0)
    );

    public static List<Comment> COMMENTS = List.of(
            Comment.create(firstComment, firstUser, thirdPost, "Congrats!!"),
            Comment.create(secondComment, firstUser, thirdPost, "Thanks :)"),
            Comment.create(thirdComment, thirdUser, thirdPost, "I hope I will be able to do the same soon"),
            Comment.create(fourthComment, firstUser, thirdPost, "One day :("),
            Comment.create(fifthComment, firstUser, fourthPost, "I said something"),
            Comment.create(sixthComment, thirdUser, fourthPost, "Nice group"),
            Comment.create(seventhComment, firstUser, fourthPost, "When do we party>"),
            Comment.create(eightComment, thirdUser, fourthPost, "Soon will do my first post"),
            Comment.create(ninthComment, thirdUser, eightPost, "Nice xD"),
            Comment.create(tenthComment, firstUser, eightPost, "Great")
    );
}
