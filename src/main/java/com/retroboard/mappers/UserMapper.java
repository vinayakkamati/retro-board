package com.retroboard.mappers;

import com.retroboard.dtos.UserDTO;
import com.retroboard.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserEntity DtoToUserEntity(UserDTO userDTO);
    UserDTO UserToDto(UserEntity userEntity);
}
