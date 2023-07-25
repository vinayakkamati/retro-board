package com.retroboard.mapper;

import com.retroboard.dto.CommentDto;
import com.retroboard.model.Comment;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {

   Comment DtoToCommentEntity(CommentDto commentDto);
}
