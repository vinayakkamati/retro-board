package com.retroboard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retroboard.db.CommentDAO;
import com.retroboard.dtos.CommentDTO;
import com.retroboard.entities.CommentEntity;
import com.retroboard.mappers.CommentMapper;
import com.retroboard.services.CommentService;
import com.retroboard.validators.CommentCreateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static com.retroboard.mock.CommentMock.getCommentDTO;
import static com.retroboard.mock.CommentMock.getCommentEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
class CommentControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    CommentDAO commentDAO;

    @MockBean
    private CommentCreateValidator commentCreateValidator;

    @MockBean
    private CommentService commentService;

    @Mock
    private CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    protected ObjectMapper mapper;

    private static final String BASE_URL = "http://localhost:8080/api/comments";

    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        MockitoAnnotations.openMocks(this);
        CommentEntity commentEntity = getCommentEntity();
        Mockito.when(commentMapper.DtoToCommentEntity(Mockito.any(CommentDTO.class))).thenReturn(commentEntity);
        Mockito.when(commentDAO.findAll()).thenReturn(List.of(commentEntity));
        Mockito.when(commentDAO.save(Mockito.any(CommentEntity.class))).thenReturn(commentEntity);
        Mockito.when(commentDAO.findById(Mockito.anyLong())).thenReturn(Optional.of(commentEntity));
    }

    @Test
    void getComments() throws Exception {
        this.mockMvc.perform(get(BASE_URL+"/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(commentService, Mockito.times(1)).findAll();
    }

    @Test
    void createComment() throws Exception {
        CommentDTO commentDTO = getCommentDTO();
        this.mockMvc.perform(post(BASE_URL + "/create")
                .content(mapper.writeValueAsString(commentDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteComment() throws Exception {
        this.mockMvc.perform(delete(BASE_URL+"/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void editComment() throws Exception {
        CommentDTO commentDTO = getCommentDTO();
        this.mockMvc.perform(put(BASE_URL + "/edit/1")
                        .content(mapper.writeValueAsBytes(commentDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//        Mockito.verify(commentService,Mockito.times(1)).updateComment(ArgumentMatchers.refEq(commentDTO));
    }
}