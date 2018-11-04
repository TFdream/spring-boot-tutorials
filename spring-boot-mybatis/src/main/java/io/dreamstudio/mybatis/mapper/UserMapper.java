package io.dreamstudio.mybatis.mapper;

import io.dreamstudio.mybatis.model.User;

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
