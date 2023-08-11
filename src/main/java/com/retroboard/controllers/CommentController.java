package com.retroboard.controllers;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.services.CommentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value = "/")
    public List<CommentDTO> getComments(){
        return commentService.findAll();
    }

    @PostMapping(value = "/create")
    public void createComment(@RequestBody @Valid CommentDTO commentDto){
        commentService.saveComment(commentDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }

    @PutMapping(value = "/edit/{id}")
    public void editComment(@RequestBody CommentDTO commentDTO){
        commentService.updateComment(commentDTO);
    }

}
