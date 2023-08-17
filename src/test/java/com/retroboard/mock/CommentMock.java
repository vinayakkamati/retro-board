package com.retroboard.mock;

import com.retroboard.dtos.CommentDTO;
import com.retroboard.entities.CommentEntity;
import com.retroboard.enums.CommentType;

import java.time.LocalDate;

import static com.retroboard.mock.UserMock.getUserDTO;
import static com.retroboard.mock.UserMock.getUserEntity;

public class CommentMock {
    public static CommentEntity getCommentEntity() {
        return new CommentEntity(1L,"Communication", CommentType.WENT_WELL, LocalDate.now(), getUserEntity());
    }

    public static CommentDTO getCommentDTO() {
        return new CommentDTO(1L,"Communication","WENT_WELL", getUserDTO());

    }

}
