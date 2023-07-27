package com.retroboard.services.impls;

import com.retroboard.entities.CommentEntity;
import com.retroboard.db.CommentDAO;
import com.retroboard.services.CommentService;
import com.retroboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;
    @Autowired
    UserService userService;

    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public void saveComment(CommentEntity commentEntity) {
        commentEntity.setDateCreated(LocalDate.now());
        commentDAO.save(commentEntity);
    }

    @Override
    public Iterable<CommentEntity> findAll() {
        return commentDAO.findAll();
    }

    @Override
    public void deleteComment(Long id) {
        commentDAO.deleteById(id);
    }

    @Override
    public Optional<CommentEntity> findById(Long id) {
        return commentDAO.findById(id);
    }
}
