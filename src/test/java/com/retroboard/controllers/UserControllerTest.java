package com.retroboard.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retroboard.db.UserDAO;
import com.retroboard.dtos.UserDTO;
import com.retroboard.entities.UserEntity;
import com.retroboard.mappers.UserMapper;
import com.retroboard.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.retroboard.mock.UserMock.getUserDTO;
import static com.retroboard.mock.UserMock.getUserEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    UserDAO userDAO;

    @MockBean
    private UserService userService;

    @Mock
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    protected ObjectMapper mapper;
    private static final String BASE_URL = "http://localhost:8080/api/user";

    @BeforeEach
    public void init(){
        mapper = new ObjectMapper();
        UserEntity user = getUserEntity();
        MockitoAnnotations.openMocks(this);
        Mockito.when(userDAO.findByEmailId(Mockito.anyString())).thenReturn(user);
    }

    @Test
    void createUser() throws Exception {
        UserDTO userDTO = getUserDTO();
        this.mockMvc.perform(post(BASE_URL + "/create")
                .content(mapper.writeValueAsString(userDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
//        Mockito.verify(userService, Mockito.times(1)).saveUser(userDTO);
    }

    @Test
    void loginUser() throws Exception {
        UserDTO userDTO = getUserDTO();
        this.mockMvc.perform(post(BASE_URL + "/login")
                .content(mapper.writeValueAsString(userDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}