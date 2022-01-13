package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(String userId);

    Iterable<UserDto> getUserByAll();

    UserDto getUserDetailsByUserEmail(String email);
}
