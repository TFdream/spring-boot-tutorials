package com.mindflow.springboot.mybatis.service.impl;

import com.mindflow.springboot.mybatis.mapper.UserMapper;
import com.mindflow.springboot.mybatis.model.User;
import com.mindflow.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-14 17:37
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public User addUser(String username) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("12345");
        user.setEmail(username+"@163.com");
        user.setAge(28);
        user.setRegisterTime(new Date());
        userMapper.insert(user);
        return user;
    }
}
