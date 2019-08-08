package io.dreamstudio.springboot.druid.mapper;

import io.dreamstudio.springboot.druid.BaseSpringBootJUnitTest;
import io.dreamstudio.springboot.druid.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
public class UserMapperTest extends BaseSpringBootJUnitTest {

    @Resource
    private UserMapper userMapper;

    private Long userId = 15L;

    @Test
    @Ignore
    public void testQuery() {
        User user = userMapper.selectByPrimaryKey(userId);
        System.out.println(user);
    }

}
