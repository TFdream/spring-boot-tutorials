package io.dreamstudio.springboot.jedis.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

/**
 * @author Ricky Fung
 */
@Configuration
public class RedisTemplateConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        //设置序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer); // key序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer); // value序列化
        redisTemplate.setHashKeySerializer(stringSerializer); // Hash key序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer); // Hash value序列化

        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
        return template;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory (DataJedisProperties dataJedisProperties) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(dataJedisProperties.getHost());
        config.setPort(dataJedisProperties.getPort());
        config.setPassword(RedisPassword.of(dataJedisProperties.getPassword()));

        JedisClientConfiguration.JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();

        builder.readTimeout(dataJedisProperties.getTimeout())
                .connectTimeout(dataJedisProperties.getTimeout());
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(dataJedisProperties.getMaxIdle());
        jedisPoolConfig.setMinIdle(dataJedisProperties.getMinIdle());
        jedisPoolConfig.setMaxTotal(dataJedisProperties.getMaxActive());
        jedisPoolConfig.setMaxWaitMillis(dataJedisProperties.getMaxWaitMillis());
        builder.usePooling().poolConfig(jedisPoolConfig);

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(config, builder.build());
        return jedisConnectionFactory;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public DataJedisProperties dataJedisProperties(){
        return new DataJedisProperties();
    }

    class DataJedisProperties{
        private  String host;

        private  String password;

        private int port;

        private Duration timeout;

        private int minIdle;

        private int maxIdle;

        private int maxActive;

        private long maxWaitMillis;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public Duration getTimeout() {
            return timeout;
        }

        public void setTimeout(Duration timeout) {
            this.timeout = timeout;
        }

        public int getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(int minIdle) {
            this.minIdle = minIdle;
        }

        public int getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
        }

        public int getMaxActive() {
            return maxActive;
        }

        public void setMaxActive(int maxActive) {
            this.maxActive = maxActive;
        }

        public long getMaxWaitMillis() {
            return maxWaitMillis;
        }

        public void setMaxWaitMillis(long maxWaitMillis) {
            this.maxWaitMillis = maxWaitMillis;
        }
    }

}
