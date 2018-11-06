package io.dreamstudio.springboot.redis.service;

import io.dreamstudio.springboot.redis.BaseSpringBootJUnitTest;
import io.dreamstudio.springboot.redis.model.User;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
public class RedisOperationServiceTest extends BaseSpringBootJUnitTest {

    @Resource(name = "redisOperationService")
    private RedisOperationService redisOperationService;

    @Test
    @Ignore
    public void testKey() {
        String key1 = "key1";
        redisOperationService.set(key1, "foo");
        System.out.println(redisOperationService.get(key1));

        String key2 = "user1";
        User user = new User();
        user.setId(15L);
        user.setName("ricky");
        user.setAge(29);
        redisOperationService.setObject(key2, user);
        User result = (User) redisOperationService.getObject(key2);
        System.out.println(result);
    }
}
