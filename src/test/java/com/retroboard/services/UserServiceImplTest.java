package com.retroboard.services;

import com.retroboard.db.UserDAO;
import com.retroboard.dtos.UserDTO;
import com.retroboard.entities.UserEntity;
import com.retroboard.mappers.UserMapper;
import com.retroboard.services.impls.UserServiceImpl;
import com.retroboard.validators.UserCreateValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.retroboard.mock.UserMock.getUserDTO;
import static com.retroboard.mock.UserMock.getUserEntity;

class UserServiceImplTest {
    @Mock
    UserDAO userDAO;

    @Mock
    private UserCreateValidator userCreateValidator;

    @Mock
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void init(){
        userService = new UserServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveUser() {
        UserDTO userDTO = getUserDTO();
        UserEntity user = getUserEntity();
        Mockito.when(userMapper.DtoToUserEntity(Mockito.any(UserDTO.class))).thenReturn(user);
        userService.saveUser(userDTO);
        Mockito.verify(userCreateValidator,Mockito.times(1)).validate(userDTO);
        Mockito.verify(userDAO,Mockito.times(1)).save(user);
    }

    @Test
    void findUser() {
        Long id = 1L;
        userService.findUser(id);
        Mockito.verify(userDAO,Mockito.times(1)).findById(1L);
    }

    @Test
    void validateUser() {
        UserDTO userDTO = getUserDTO();
        UserEntity user = getUserEntity();
        userService.saveUser(userDTO);
        Mockito.when(userMapper.DtoToUserEntity(Mockito.any(UserDTO.class))).thenReturn(user);
        Mockito.when(userDAO.findByEmailId(userDTO.getEmailId())).thenReturn(user);
        userService.validateUser(userDTO);
        Mockito.verify(userDAO, Mockito.times(1)).findByEmailId(userDTO.getEmailId());
    }
}