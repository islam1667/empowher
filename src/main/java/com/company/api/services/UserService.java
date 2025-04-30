package com.company.api.services;

import com.company.api.dto.UserEntityDto;

public interface UserService {
    UserEntityDto createUser(UserEntityDto userDto);

    void registerUser(UserEntityDto userDto);

    void verifyUserByToken(String token);
}
