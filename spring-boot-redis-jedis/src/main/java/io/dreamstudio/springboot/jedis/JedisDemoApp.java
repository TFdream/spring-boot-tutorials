package io.dreamstudio.springboot.jedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ricky Fung
 */
@SpringBootApplication
public class JedisDemoApp {

    public static void main( String[] args ) throws Exception {
        SpringApplication.run(JedisDemoApp.class, args);
    }
}
