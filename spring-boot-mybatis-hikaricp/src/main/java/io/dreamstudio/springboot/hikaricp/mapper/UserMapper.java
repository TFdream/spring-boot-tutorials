package io.dreamstudio.springboot.hikaricp.mapper;

import io.dreamstudio.springboot.hikaricp.model.User;

/**
 * @author Ricky Fung
 */
public interface UserMapper {

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKey(User user);

    int updateByPrimaryKeySelective(User user);

    int deleteByPrimaryKey(Long id);
}
