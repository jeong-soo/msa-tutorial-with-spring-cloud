package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.jpa.UserEntity;
import dev.jsoo.userservice.jpa.UserRepository;
import dev.jsoo.userservice.mapStruct.UserMapper;
import dev.jsoo.userservice.vo.ResponseOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
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
        log.info("USER SERVICE CREATE USER {}", userEntity.toString());
        userRepository.save(userEntity);

        return userDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserDto userDto = UserMapper.INSTANCE.entityToDto(userRepository.findById(userId));
        List<ResponseOrder> orders = new ArrayList<>();
        userDto.setOrders(orders);
        return userDto;
    }

    @Override
    public Iterable<UserDto> getUserByAll() {
        return UserMapper.INSTANCE.entityToDto(userRepository.findAll());
    }
}
