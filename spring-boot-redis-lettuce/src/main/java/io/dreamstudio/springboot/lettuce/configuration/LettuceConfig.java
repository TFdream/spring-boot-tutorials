package io.dreamstudio.springboot.lettuce.configuration;

import io.dreamstudio.springboot.lettuce.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Ricky Fung
 */
@Configuration
public class LettuceConfig {

    @Bean
    public RedisTemplate<String, Student> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);

        //Jackson2JsonRedisSerializer
        RedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Student.class);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
        return template;
    }
}
