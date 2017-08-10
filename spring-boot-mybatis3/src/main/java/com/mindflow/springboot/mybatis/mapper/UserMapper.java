package com.mindflow.springboot.mybatis.mapper;

import com.mindflow.springboot.mybatis.model.User;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-14 17:25
 */
public interface UserMapper {

    User getUserByName(String username);

    int insert(User user);
}
