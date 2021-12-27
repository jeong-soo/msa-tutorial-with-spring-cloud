package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());
        return null;
    }
}
