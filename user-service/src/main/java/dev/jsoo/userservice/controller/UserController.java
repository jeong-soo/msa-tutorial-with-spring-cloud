package dev.jsoo.userservice.controller;

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
    public String status() {
        return String.format("It's Working in User Service"
                + ", port(local.server.port)=" + env.getProperty("local.server.port")
                + ", port(server.port)=" + env.getProperty("server.port")
                + ", token.secret=" + env.getProperty("token.secret")
                + ", token.expiration_time" + env.getProperty("token.expiration_time"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getMessage();
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                UserMapper.INSTANCE.dtoToResponse(
                        userService.createUser(
                                UserMapper.INSTANCE.requestToDto(user))));
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
