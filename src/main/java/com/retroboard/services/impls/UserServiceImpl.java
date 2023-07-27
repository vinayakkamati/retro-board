package com.retroboard.services.impls;

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
        userDAO.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findUser(Long id) {
        return userDAO.findById(id);
    }
}
