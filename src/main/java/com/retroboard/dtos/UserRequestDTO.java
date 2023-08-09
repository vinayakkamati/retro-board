package com.retroboard.dtos;

public class UserRequestDTO {
    private Long id;
    private String userName;
    private String emailId;
    private String password;

    public UserRequestDTO() {
    }

    public UserRequestDTO(Long id, String userName, String emailId, String password) {
        this.id = id;
        this.userName = userName;
        this.emailId = emailId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
