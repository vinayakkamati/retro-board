package com.retroboard.service;

import com.retroboard.model.Comment;

public interface CommentService {
    void saveComment(Comment comment);
    Iterable<Comment> findAll();
}
