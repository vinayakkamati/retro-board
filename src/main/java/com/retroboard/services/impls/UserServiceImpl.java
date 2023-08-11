package com.retroboard.services.impls;

import com.retroboard.dtos.UserDTO;
import com.retroboard.entities.UserEntity;
import com.retroboard.db.UserDAO;
import com.retroboard.enums.ErrorReason;
import com.retroboard.exceptions.BadRequestException;
import com.retroboard.exceptions.ErrorMessage;
import com.retroboard.exceptions.NotFoundException;
import com.retroboard.mappers.UserMapper;
import com.retroboard.services.UserService;
import com.retroboard.validators.UserCreateValidator;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.retroboard.constants.UserConstants.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserCreateValidator userCreateValidator;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Override
    public void saveUser(UserDTO user) {
        userCreateValidator.validate(user);
        if (userDAO.existsByEmailId(user.getEmailId())) {
            throw new BadRequestException(new ErrorMessage(HttpStatus.CONFLICT, ErrorReason.BAD_REQUEST, EMAIL_EXISTS));
        }
        UserEntity userEntity = userMapper.DtoToUserEntity(user);
        userDAO.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findUser(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public UserDTO validateUser(UserDTO userDTO) {
        UserEntity user = userDAO.findByEmailId(userDTO.getEmailId());
        if (user == null) {
            throw new NotFoundException(new ErrorMessage(HttpStatus.NOT_FOUND, ErrorReason.NOT_FOUND, USER_NOT_FOUND));
        }
        if (!userDTO.getPassword().equals(user.getPassword())) {
            throw new BadRequestException(new ErrorMessage(HttpStatus.CONFLICT, ErrorReason.BAD_REQUEST, PASSWORD_INCORRECT));
        }
        return userMapper.UserToDto(user);
    }
}
