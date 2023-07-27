package com.retroboard.services;

import com.retroboard.entities.CommentEntity;

import java.util.Optional;

public interface CommentService {
    void saveComment(CommentEntity commentEntity);
    Iterable<CommentEntity> findAll();

    void deleteComment(Long id);

    Optional<CommentEntity> findById(Long id);
}
