package com.jsjchai.springboot.demo.service;

import com.jsjchai.springboot.demo.model.User;

import java.util.List;


/**
 * @author jsjchai
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> finadAll();

    User getById(Long id);
}
