package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.jpa.UserEntity;
import dev.jsoo.userservice.jpa.UserRepository;
import dev.jsoo.userservice.mapStruct.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setId(UUID.randomUUID().toString());
        UserEntity userEntity = UserMapper.INSTANCE.dtoToEntity(userDto);
        userEntity.setPwd("mock password");

        userRepository.save(userEntity);

        return userDto;
    }
}
