package io.dreamstudio.springboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring Cache
 * @author Ricky Fung
 */
@SpringBootApplication
@EnableCaching
public class SpringCacheApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApp.class, args);
    }
}
