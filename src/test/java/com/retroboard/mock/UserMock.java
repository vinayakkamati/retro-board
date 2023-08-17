package com.retroboard.mock;

import com.retroboard.dtos.UserDTO;
import com.retroboard.entities.UserEntity;

public class UserMock {

    public static UserEntity getUserEntity() {
        return new UserEntity(1L, "Vinayak", "vinayak@gmail.com", "1234");
    }

    public static UserDTO getUserDTO() {
        return new UserDTO(1L, "Vinayak", "vinayak@gmail.com", "1234");
    }

}
