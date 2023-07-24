package com.retroboard.dto;

public class CommentDto {
    private Long id;
    private String comment;
    private String commentType;
    private String dateCreated;
    private String createdBy;

    public CommentDto() {
    }

    public CommentDto(Long id, String comment, String commentType, String dateCreated, String createdBy) {
        this.id = id;
        this.comment = comment;
        this.commentType = commentType;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
    }

    public CommentDto(String comment) {
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
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
