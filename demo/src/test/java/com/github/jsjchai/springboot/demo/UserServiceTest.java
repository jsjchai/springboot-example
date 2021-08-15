package com.github.jsjchai.springboot.demo;

import static org.junit.Assert.assertTrue;

import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.service.UserService;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        List<User> list = userService.finadAll();
        assertTrue(list.size() > 0);
    }
}
