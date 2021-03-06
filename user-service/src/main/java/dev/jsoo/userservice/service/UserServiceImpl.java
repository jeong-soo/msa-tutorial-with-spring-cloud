package dev.jsoo.userservice.service;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.entity.UserEntity;
import dev.jsoo.userservice.repository.UserRepository;
import dev.jsoo.userservice.mapStruct.UserMapper;
import dev.jsoo.userservice.vo.ResponseOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setId(UUID.randomUUID().toString());
        UserEntity userEntity = UserMapper.INSTANCE.dtoToEntity(userDto);
        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(userEntity);

        return userDto;
    }

    @Override
    public UserDto getUserById(String userId) {
        UserDto userDto = UserMapper.INSTANCE.entityToDto(userRepository.findById(userId));
        List<ResponseOrder> orders = new ArrayList<>();
        userDto.setOrders(orders);
        return userDto;
    }

    @Override
    public Iterable<UserDto> getUserByAll() {
        return UserMapper.INSTANCE.entityToDto(userRepository.findAll());
    }

    @Override
    public UserDto getUserDetailsByUserEmail(String email) {
        return UserMapper.INSTANCE.entityToDto(userRepository.findByEmail(email));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username);
        if(userEntity == null) throw new UsernameNotFoundException(username);

        return new User(userEntity.getEmail(), userEntity.getPassword(),
                true, true, true, true,
                new ArrayList<>());
    }
}
