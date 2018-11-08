package io.dreamstudio.springboot.redis.service;

import io.dreamstudio.springboot.redis.BaseSpringBootJUnitTest;
import io.dreamstudio.springboot.redis.model.Book;
import org.junit.Ignore;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

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
        Book book = new Book();
        book.setId(15L);
        book.setAuthor("ricky");
        book.setIsbn(29);
        book.setPublishTime(new Date());
        redisOperationService.setObject(key2, book);
        Book result = redisOperationService.getObject(key2);
        System.out.println(result);
    }
}
