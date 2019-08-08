package io.dreamstudio.springboot.mybatis.mapper;

import io.dreamstudio.springboot.mybatis.model.User;
import io.dreamstudio.springboot.mybatis.BaseSpringBootJUnitTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ricky Fung
 */
public class UserMapperTest extends BaseSpringBootJUnitTest {

    @Resource
    private UserMapper userMapper;

    @Test
    @Ignore
    public void testQuery() {
        User user = userMapper.selectByPrimaryKey(3L);
        System.out.println(user);
    }

    @Test
    @Ignore
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
