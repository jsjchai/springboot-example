package com.github.jsjchai.springboot.demo.controller;

import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.query.UserQuery;
import com.github.jsjchai.springboot.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "UserStatController", description = "用户")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    @Operation(summary = "查询所有用户信息")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/getUserById")
    @Operation(summary = "根据id查询用户信息")
    public User getUserById(@RequestParam Long id) {
        User user = userService.getById(id);
        if (user == null) {
            throw new RuntimeException("User not found with id " + id);
        }
        return user;
    }

    @GetMapping(value = "/getUser")
    @Operation(summary = "查询用户信息")
    public User getUser(@RequestBody UserQuery param) {
        User user = userService.getById(param.getId());
        if (user == null) {
            throw new RuntimeException("User not found with id " + param.getId());
        }
        return user;
    }
}
