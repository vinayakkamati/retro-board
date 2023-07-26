package com.retroboard.service.impl;

import com.retroboard.model.Comment;
import com.retroboard.model.User;
import com.retroboard.repository.CommentRepository;
import com.retroboard.service.CommentService;
import com.retroboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    @Autowired
    UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    @Transactional
    public void saveComment(Comment comment) {
        User user = new User();
        user.setUserName("vinayak");
        userService.saveUser(user);

        comment.setCreatedBy(user);
        comment.setDateCreated(LocalDate.now());

        commentRepository.save(comment);
    }

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }
}
