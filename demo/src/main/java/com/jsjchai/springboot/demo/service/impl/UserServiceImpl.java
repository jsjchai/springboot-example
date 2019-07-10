package com.jsjchai.springboot.demo.service.impl;


import com.jsjchai.springboot.demo.dao.UserDao;
import com.jsjchai.springboot.demo.model.User;
import com.jsjchai.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<User> finadAll() {
        return userDao.finaAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
