package com.bachelor.backend.domain.feed;

import org.springframework.stereotype.Repository;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
@Repository
public class PostsRepository {

    List<Post> posts = List.of();

    public void save(Post first) {
        final List<Post> newPosts = posts.stream()
                .filter(p -> !p.getUuid().equals(first.getUuid()))
                .collect(Collectors.toList());
        newPosts.add(first);
        posts = newPosts;
    }

    public void saveAll(List<Post> posts) {
        final List<Post> newPosts = new ArrayList<>(this.posts);
        newPosts.addAll(posts);
        this.posts = newPosts;
    }

    public Optional<Post> findByUuid(UUID uuid) {
        return posts.stream()
                .filter(p -> p.getUuid().equals(uuid))
                .findFirst();
    }

    public List<Post> findAll() {
        return posts;
    }

    public void clear() {
        posts = List.of();
    }

    public List<Post> findByTarget(UUID uuid) {
        return posts.stream()
                .filter(p -> p.getTarget().equals(uuid))
                .collect(Collectors.toList());
    }

    public void addCommentToPost(UUID postUuid) {
        posts = posts.stream()
                .map(p -> {
                    if (p.getUuid().equals(postUuid)) {
                        return p.copy()
                                .withNumberOfComments(p.getNumberOfComments() + 1);
                    }

                    return p;
                })
                .collect(Collectors.toList());
    }
}
