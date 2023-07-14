package com.github.jsjchai.springboot.demo;


import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        List<User> list = userService.findAll();
        assertTrue(list.size() > 0);
    }
}
