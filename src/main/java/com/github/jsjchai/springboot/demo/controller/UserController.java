package com.github.jsjchai.springboot.demo.controller;

import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.query.UserQuery;
import com.github.jsjchai.springboot.demo.service.UserService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name="UserStatController",description="用户")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    @Operation( summary = "查询所有用户信息")
    public List<User> findAll() {
        return userService.finadAll();
    }

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return  用户信息
     */
    @Operation( summary = "根据id查询用户信息")
    @PostMapping(value = "/getById",produces="application/x-www-form-urlencoded;charset=UTF-8")
    public User getById(@RequestParam Long id){
        return userService.getById(id);
    }

    @Operation( summary = "查询用户信息")
    @PostMapping(value = "/getByJson",produces="application/json;charset=UTF-8")
    public User getByJson(@RequestBody UserQuery param){
        return userService.getById(param.getId());
    }
}
