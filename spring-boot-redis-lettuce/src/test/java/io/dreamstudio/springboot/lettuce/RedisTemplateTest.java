package io.dreamstudio.springboot.lettuce;

import io.dreamstudio.springboot.lettuce.model.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Ricky Fung
 */
public class RedisTemplateTest extends BaseSpringBootJUnitTest {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Student> redisTemplate;

    @Test
    @Ignore
    public void testKey() {
        String key = "demo:v1";
        Student student = new Student();
        student.setId(15L);
        student.setName("ricky");
        student.setBirthday(new Date());
        student.setMale(true);
        redisTemplate.opsForValue().set(key, student, 10, TimeUnit.MINUTES);

        Student stu = redisTemplate.opsForValue().get(key);
        System.out.println(stu);
    }
}
