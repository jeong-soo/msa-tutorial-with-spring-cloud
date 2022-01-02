package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(String userId);

    Iterable<UserDto> getUserByAll();
}
