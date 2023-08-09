package com.retroboard.services.impls;

import com.retroboard.dtos.UserRequestDTO;
import com.retroboard.entities.UserEntity;
import com.retroboard.db.UserDAO;
import com.retroboard.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    public void saveUser(UserEntity userEntity) {
        if(userDAO.existsByEmailId(userEntity.getEmailId())){
//            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
            throw new IllegalArgumentException("Email is already taken!");
        }
        userDAO.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findUser(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public UserEntity validateUser(UserRequestDTO userRequestDTO) {
        UserEntity user = userDAO.findByEmailId(userRequestDTO.getEmailId());
        if(!userRequestDTO.getPassword().equals(user.getPassword())){
            throw new IllegalArgumentException("Enter correct emailId or password!");
        }
        return user;
    }
}
