package io.dreamstudio.springboot.mybatis.mapper;

import io.dreamstudio.mybatis.mapper.UserMapper;
import io.dreamstudio.mybatis.model.User;
import io.dreamstudio.springboot.mybatis.BaseSpringBootJUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Ricky Fung
 */
public class UserMapperTest extends BaseSpringBootJUnitTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQuery() {
        User user = userMapper.selectByPrimaryKey(3L);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("张三");
        user.setPassword("12345");
        user.setAge(28);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);

        System.out.println(user);
    }
}
