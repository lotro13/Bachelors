package com.bachelor.backend.domain.feed;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CommentsRepository {

    List<Comment> comments = List.of();

    public List<Comment> findAll() {
        return comments;
    }

    public void save(Comment firstComment) {
        var newComments = new ArrayList<>(comments);
        newComments.add(firstComment);
        comments = newComments;
    }

    public void saveAll(List<Comment> comments) {
        var newComments = new ArrayList<>(this.comments);
        newComments.addAll(comments);
        this.comments = newComments;
    }

    public void clear() {
        comments = List.of();
    }

    public List<Comment> findByTarget(UUID target) {
        return comments.stream()
                .filter(c -> c.getTargetUuid().equals(target))
                .collect(Collectors.toList());
    }
}
