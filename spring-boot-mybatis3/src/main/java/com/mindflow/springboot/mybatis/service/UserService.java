package com.mindflow.springboot.mybatis.service;

import com.mindflow.springboot.mybatis.model.UserDO;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-14 17:35
 */
public interface UserService {

    UserDO getUserByName(String username);

    UserDO addUser(String username);
}
