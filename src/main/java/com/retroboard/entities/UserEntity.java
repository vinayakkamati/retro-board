package com.retroboard.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "createdBy")
    private List<CommentEntity> commentEntities = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(String userName, String emailId) {
        this.userName = userName;
        this.emailId = emailId;
    }


    public UserEntity(Long id, String userName, String emailId) {
        this.id = id;
        this.userName = userName;
        this.emailId = emailId;
    }

    public UserEntity(Long id, String userName, String emailId, String password) {
        this.id = id;
        this.userName = userName;
        this.emailId = emailId;
        this.password =password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
