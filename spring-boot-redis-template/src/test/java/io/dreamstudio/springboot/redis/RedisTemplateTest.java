package io.dreamstudio.springboot.redis;

import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
public class RedisTemplateTest extends BaseSpringBootJUnitTest {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testKey() {

    }
}
