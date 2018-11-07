package io.dreamstudio.springboot.druid.mapper;

import io.dreamstudio.springboot.druid.BaseSpringBootJUnitTest;
import io.dreamstudio.springboot.druid.model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Ricky Fung
 */
public class UserMapperTest extends BaseSpringBootJUnitTest {

    @Autowired
    private UserMapper userMapper;

    private Long userId = 15L;

    @Test
    @Ignore
    public void testQuery() {
        User user = userMapper.selectByPrimaryKey(userId);
        System.out.println(user);
    }

}
