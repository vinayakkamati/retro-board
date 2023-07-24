package com.retroboard.model;

import com.retroboard.enums.CommentType;

import java.time.LocalDate;

public class Comment {
    private Long id;
    private String comment;
    private CommentType commentType;
    private LocalDate dateCreated;
    private String createdBy;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(Long id, String comment, CommentType commentType, LocalDate dateCreated, String createdBy) {
        this.id = id;
        this.comment = comment;
        this.commentType = commentType;
        this.dateCreated = dateCreated;
        this.createdBy = createdBy;
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

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
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
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentType=" + commentType +
                ", dateCreated=" + dateCreated +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
