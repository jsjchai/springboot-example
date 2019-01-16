package com.jsjchai.springboot.demo.dao;

import com.jsjchai.springboot.demo.model.User;
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
