package com.retroboard.db;

import com.retroboard.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO extends JpaRepository<CommentEntity, Long> {
}
