package com.github.jsjchai.springboot.demo.controller;

import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.model.UserParam;
import com.github.jsjchai.springboot.demo.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.finadAll();
    }

    /**
     *
     * @param id 用户id
     * @return  用户信息
     */
    @PostMapping(value = "/getById",produces="application/x-www-form-urlencoded;charset=UTF-8")
    public User getById(@RequestParam Long id){
        return userService.getById(id);
    }

    @PostMapping(value = "/getByJson",produces="application/json;charset=UTF-8")
    public User getByJson(@RequestBody UserParam param){
        return userService.getById(param.getId());
    }
}
