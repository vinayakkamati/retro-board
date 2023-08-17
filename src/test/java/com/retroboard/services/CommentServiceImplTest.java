package com.retroboard.services;

import com.retroboard.db.CommentDAO;
import com.retroboard.dtos.CommentDTO;
import com.retroboard.entities.CommentEntity;
import com.retroboard.mappers.CommentMapper;
import com.retroboard.services.impls.CommentServiceImpl;
import com.retroboard.validators.CommentCreateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.retroboard.mock.CommentMock.getCommentDTO;
import static com.retroboard.mock.CommentMock.getCommentEntity;

class CommentServiceImplTest {

    @Mock
    CommentDAO commentDAO;

    @Mock
    private CommentCreateValidator commentCreateValidator;

    @InjectMocks
    private CommentServiceImpl commentService;

    @Mock
    private CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    @BeforeEach
    public void init(){
        commentService = new CommentServiceImpl(commentDAO);
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void saveCommentSuccess() {
        CommentEntity commentEntity = getCommentEntity();
        Mockito.when(commentMapper.DtoToCommentEntity(Mockito.any(CommentDTO.class))).thenReturn(commentEntity);
        CommentDTO commentDTO = getCommentDTO();
        commentService.saveComment(commentDTO);
        Mockito.verify(commentCreateValidator,Mockito.times(1)).validate(commentDTO);
        Mockito.verify(commentDAO, Mockito.times(1)).save(commentEntity);
    }

    @Test
    void findAll() {
        Mockito.when(commentDAO.findAll()).thenReturn(List.of(new CommentEntity()));
        commentService.findAll();
        Mockito.verify(commentDAO, Mockito.times(1)).findAll();
    }

    @Test
    void deleteComment() {
        Long id = 1L;
        commentService.deleteComment(id);
        Mockito.verify(commentDAO, Mockito.times(1)).deleteById(id);
    }

    @Test
    void findById() {
        Long id = 1L;
        commentService.findById(id);
        Mockito.verify(commentDAO, Mockito.times(1)).findById(id);
    }

    @Test
    void updateComment() {
        CommentDTO commentDTO = getCommentDTO();
        CommentEntity commentEntity = getCommentEntity();
        Mockito.when(commentMapper.DtoToCommentEntity(Mockito.any(CommentDTO.class))).thenReturn(commentEntity);
        commentService.updateComment(commentDTO);
        Mockito.verify(commentCreateValidator,Mockito.times(1)).validate(commentDTO);
        Mockito.verify(commentDAO, Mockito.times(1)).findById(commentDTO.getId());
        Mockito.verify(commentDAO, Mockito.times(1)).save(commentEntity);
    }
}