package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {
    public UserDto createUser(UserDto userDto);
}