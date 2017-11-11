package springboot.tutorials.mybatis.annotation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ricky Fung
 */
@Configuration
@ConfigurationProperties("spring.redis")
public class RedisConfiguration {

}
