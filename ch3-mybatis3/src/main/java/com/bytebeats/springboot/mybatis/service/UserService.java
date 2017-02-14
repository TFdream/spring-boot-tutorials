package com.bytebeats.springboot.mybatis.service;

import com.bytebeats.springboot.mybatis.model.User;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-14 17:35
 */
public interface UserService {

    User getUserByName(String username);

    User addUser(String username);
}
