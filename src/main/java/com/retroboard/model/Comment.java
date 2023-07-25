package com.retroboard.model;

import com.retroboard.enums.CommentType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "comment_type")
    private CommentType commentType;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User createdBy;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(Long id, String comment, CommentType commentType, LocalDate dateCreated, User createdBy) {
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
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
