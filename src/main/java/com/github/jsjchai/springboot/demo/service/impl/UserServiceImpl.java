package com.github.jsjchai.springboot.demo.service.impl;


import com.github.jsjchai.springboot.demo.dao.UserDao;
import com.github.jsjchai.springboot.demo.model.User;
import com.github.jsjchai.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jsjchai
 */
@Service
public class UserServiceImpl implements UserService {

    private final  UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.finaAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
