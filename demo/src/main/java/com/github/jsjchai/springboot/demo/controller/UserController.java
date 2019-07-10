package com.github.jsjchai.springboot.demo.controller;

import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     *  	Content-Type : application/x-www-form-urlencoded  id=1 能够获取到参数  {id:"1"}无法获取到参数 @RequestParam
     *
     * @param id 用户id
     * @return  用户信息
     */
    @PostMapping("/getById")
    public User getById(@RequestBody Long id){
        return userService.getById(id);
    }
}
