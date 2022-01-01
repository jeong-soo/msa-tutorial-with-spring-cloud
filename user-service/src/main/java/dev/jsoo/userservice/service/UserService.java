package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.jpa.UserEntity;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserDto> getUserByAll();
}
