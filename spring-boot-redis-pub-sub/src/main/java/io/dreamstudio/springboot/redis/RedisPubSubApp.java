package io.dreamstudio.springboot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ricky Fung
 */
@SpringBootApplication
public class RedisPubSubApp {

    public static void main(String[] args) {
        SpringApplication.run(RedisPubSubApp.class, args);
    }
}
