package com.retroboard.model;

import com.retroboard.enums.CommentType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "type")
    private CommentType commentType;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "created_by")
    private User createdBy;

    public Comment() {
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment( String comment, CommentType commentType, LocalDate dateCreated) {
        this.comment = comment;
        this.commentType = commentType;
        this.dateCreated = dateCreated;
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
