package com.mindflow.springboot.mybatis.service;

import com.mindflow.springboot.mybatis.domain.UserDO;

/**
 * @author Ricky Fung
 */
public interface UserService {

    UserDO getUserByName(String username);

    int insert(UserDO userDO);
}
