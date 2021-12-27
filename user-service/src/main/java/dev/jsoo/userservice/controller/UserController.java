package dev.jsoo.userservice.controller;

import dev.jsoo.userservice.service.UserService;
import dev.jsoo.userservice.vo.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("welcome")
    public String welcome() {
        return greeting.getMessage();
    }
}
