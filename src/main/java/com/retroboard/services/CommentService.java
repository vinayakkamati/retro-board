package com.retroboard.services;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.entities.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    void saveComment(CommentDTO commentDTO);
    List<CommentDTO> findAll();

    void deleteComment(Long id);

    Optional<CommentEntity> findById(Long id);

    void updateComment(CommentDTO commentDTO);
}
