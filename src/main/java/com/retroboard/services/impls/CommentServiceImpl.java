package com.retroboard.services.impls;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.entities.CommentEntity;
import com.retroboard.db.CommentDAO;
import com.retroboard.enums.CommentType;
import com.retroboard.mappers.CommentMapper;
import com.retroboard.services.CommentService;
import com.retroboard.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;
    @Autowired
    UserService userService;

    private CommentMapper commentMapper = Mappers.getMapper(CommentMapper.class);

    public CommentServiceImpl(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @Override
    public void saveComment(CommentDTO commentDTO) {
        CommentEntity commentEntity = commentMapper.DtoToCommentEntity(commentDTO);
        commentEntity.setCommentType(CommentType.WENT_WELL);
        commentEntity.setCreatedBy(userService.findUser(1L).orElse(null));
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
        commentDAO.deleteById(id);
    }

    @Override
    public Optional<CommentEntity> findById(Long id) {
        return commentDAO.findById(id);
    }

    @Override
    public void updateComment(Long id, String commentDescription) {
        CommentEntity commentEntity = this.findById(id).orElse(null);
        assert commentEntity != null;
        commentEntity.setComment(commentDescription);
        commentDAO.save(commentEntity);
    }
}
