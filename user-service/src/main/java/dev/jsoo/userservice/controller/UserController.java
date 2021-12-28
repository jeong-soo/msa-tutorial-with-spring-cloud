package dev.jsoo.userservice.controller;

import dev.jsoo.userservice.dto.UserDto;
import dev.jsoo.userservice.mapStruct.UserMapper;
import dev.jsoo.userservice.service.UserService;
import dev.jsoo.userservice.vo.Greeting;
import dev.jsoo.userservice.vo.RequestUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String createUser(@RequestBody RequestUser user) {
        UserDto userDto = UserMapper.INSTANCE.requestToDto(user);
        log.info("userDto : {}", userDto.toString());
        userService.createUser(userDto);
        return "create user success";
    }
}
