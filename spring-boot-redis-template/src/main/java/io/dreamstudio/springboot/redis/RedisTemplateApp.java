package io.dreamstudio.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ricky Fung
 */
@SpringBootApplication
public class RedisTemplateApp {

    public static void main( String[] args ) throws Exception {
        SpringApplication.run(RedisTemplateApp.class, args);
    }
}
