package com.retroboard.dtos;

import com.retroboard.entities.UserEntity;

public class CommentDTO {
    private Long id;
    private String comment;
    private String commentType;
    private String dateCreated;
    private UserEntity createdBy;

    public CommentDTO() {
    }

    public CommentDTO(Long id, String comment, String commentType, String dateCreated, UserEntity createdBy) {
        this.id = id;
        this.comment = comment;
        this.commentType = commentType;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
    }

    public CommentDTO(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentType='" + commentType + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
