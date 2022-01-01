package dev.jsoo.userservice.controller;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.jpa.UserEntity;
import dev.jsoo.userservice.mapStruct.UserMapper;
import dev.jsoo.userservice.service.UserService;
import dev.jsoo.userservice.vo.Greeting;
import dev.jsoo.userservice.vo.RequestUser;
import dev.jsoo.userservice.vo.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/")
public class UserController {
    private Environment env;
    private UserService userService;

    @Autowired
    private Greeting greeting;

    @Autowired
    public UserController(Environment env, UserService userService) {
        this.env = env;
        this.userService = userService;
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        UserDto userDto = UserMapper.INSTANCE.requestToDto(user);
        log.info("userDto : {}", userDto.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.INSTANCE.dtoToResponse(userService.createUser(userDto)));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.INSTANCE.dtoToResponse(userService.getUserById(id)));
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<ResponseUser>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.INSTANCE.dtoToResponse(userService.getUserByAll()));
    }
}
