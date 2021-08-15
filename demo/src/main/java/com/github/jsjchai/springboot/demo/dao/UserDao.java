package com.github.jsjchai.springboot.demo.dao;

import com.github.jsjchai.springboot.demo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author jsjchai
 */
@Mapper
public interface UserDao {

    List<User> finaAll();

    User getById(Long id);
}
