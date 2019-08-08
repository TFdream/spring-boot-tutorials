package io.dreamstudio.springboot.hikaricp.mapper;

import io.dreamstudio.springboot.hikaricp.BaseSpringBootJUnitTest;
import io.dreamstudio.springboot.hikaricp.model.User;
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

    private Long userId = 2L;

    @Test
    @Ignore
    public void testQuery() {
        User user = userMapper.selectByPrimaryKey(userId);
        System.out.println(user);
    }

}
