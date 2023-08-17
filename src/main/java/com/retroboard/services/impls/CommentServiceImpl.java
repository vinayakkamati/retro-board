package com.retroboard.services.impls;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.entities.CommentEntity;
import com.retroboard.db.CommentDAO;
import com.retroboard.enums.ErrorReason;
import com.retroboard.exceptions.ErrorMessage;
import com.retroboard.exceptions.NotFoundException;
import com.retroboard.mappers.CommentMapper;
import com.retroboard.services.CommentService;
import com.retroboard.validators.CommentCreateValidator;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.retroboard.constants.CommentConstant.COMMENT_NOT_FOUND;
import static com.retroboard.constants.CommentConstant.WITH_ID;
import static com.retroboard.constants.UserConstants.USER_NOT_FOUND;

@Service
public class CommentServiceImpl implements CommentService {
    CommentDAO commentDAO;

    @Autowired
    CommentCreateValidator commentCreateValidator;

    private CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public void saveComment(CommentDTO commentDTO) {
        if(commentDTO.getCreatedBy() == null){
            throw new NotFoundException(new ErrorMessage(HttpStatus.NOT_FOUND, ErrorReason.NOT_FOUND, USER_NOT_FOUND));
        }
        commentCreateValidator.validate(commentDTO);
        CommentEntity commentEntity = commentMapper.DtoToCommentEntity(commentDTO);
        commentEntity.setDateCreated(LocalDate.now());
        commentDAO.save(commentEntity);
    }

    @Override
    public List<CommentDTO> findAll() {
        Iterable<CommentEntity> comment = commentDAO.findAll();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        comment.forEach(c -> commentDTOS.add(commentMapper.CommentToDto(c)));
        return commentDTOS;
    }

    @Override
    public void deleteComment(Long id) {
        try{
            commentDAO.deleteById(id);
        }catch(Exception e){
            throw new NotFoundException(
                    new ErrorMessage(HttpStatus.NOT_FOUND,
                            ErrorReason.NOT_FOUND, COMMENT_NOT_FOUND + WITH_ID + id));
        }

    }

    @Override
    public Optional<CommentEntity> findById(Long id) {
        return commentDAO.findById(id);
    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        try {
            commentCreateValidator.validate(commentDTO);
            commentDAO.findById(commentDTO.getId());
            commentDAO.save(commentMapper.DtoToCommentEntity(commentDTO));
        }catch (Exception e){
            throw new NotFoundException(
                    new ErrorMessage(HttpStatus.NOT_FOUND,
                            ErrorReason.NOT_FOUND, COMMENT_NOT_FOUND + WITH_ID + commentDTO.getId()));
        }
    }
}
