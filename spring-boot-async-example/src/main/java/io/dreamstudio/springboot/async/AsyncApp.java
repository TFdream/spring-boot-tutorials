package io.dreamstudio.springboot.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Ricky Fung
 */
@EnableAsync
@SpringBootApplication
public class AsyncApp {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApp.class, args);
    }
}
