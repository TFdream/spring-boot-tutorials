package com.mindflow.springboot.mybatis.service.impl;

import com.mindflow.springboot.mybatis.mapper.UserDOMapper;
import com.mindflow.springboot.mybatis.model.UserDO;
import com.mindflow.springboot.mybatis.model.UserDOExample;
import com.mindflow.springboot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-14 17:37
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public UserDO getUserByName(String username) {
        UserDOExample example = new UserDOExample();
        List<UserDO> list = userDOMapper.selectByExample(example);
        if(list==null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public UserDO addUser(String username) {
        UserDO user = new UserDO();
        user.setUsername(username);
        user.setPassword("12345");
        user.setEmail(username+"@163.com");
        user.setMobile("1861111111");
        user.setAge(28);
        user.setRegistyTime(new Date());
        userDOMapper.insertSelective(user);
        return user;
    }
}
