package com.retroboard.mappers;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.entities.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CommentMapper {

   @Mapping(target = "dateCreated", dateFormat = "dd.MM.yyyy")
   CommentEntity DtoToCommentEntity(CommentDTO commentDto);

   CommentDTO CommentToDto(CommentEntity commentEntity);
}
