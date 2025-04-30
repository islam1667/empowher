package com.company.api.mapper;

import com.company.api.dto.UserEntityDto;
import com.company.api.models.UserEntity;

public class UserEntityMapper {
    public static UserEntity mapToEntity(UserEntityDto dto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(dto.getUsername());
        userEntity.setEmail(dto.getEmail());
        userEntity.setPassword(dto.getPassword());
        //userEntity.setRole(dto.getRole());
        return userEntity;
    }

    public static UserEntityDto mapToDto(UserEntity userEntity){
        UserEntityDto userEntityDto = new UserEntityDto();
        userEntityDto.setUsername(userEntity.getUsername());
        userEntityDto.setEmail(userEntity.getEmail());
        userEntityDto.setPassword(userEntity.getPassword());
        //userEntityDto.setRole(userEntity.getRole());
        return userEntityDto;
    }
}
