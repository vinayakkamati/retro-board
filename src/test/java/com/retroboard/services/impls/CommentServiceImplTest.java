package com.retroboard.services.impls;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.enums.CommentType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;


@SpringBootTest
class CommentServiceImplTest {

    @Autowired
    CommentServiceImpl commentService;

    @Test
    void saveComment() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setComment("Communication went well");
        commentDTO.setCommentType(CommentType.WENT_WELL.toString());
        commentService.saveComment(commentDTO);
    }

    @Test
    void findAll() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setComment("Communication went well");
        commentDTO.setCommentType(CommentType.WENT_WELL.toString());
        commentService.saveComment(commentDTO);

        List<CommentDTO> comments = commentService.findAll();
    }
}