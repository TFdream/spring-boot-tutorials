package com.mindflow.springboot.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.mindflow.springboot.actuator"})
public class App {

    public static void main( String[] args ) throws Exception {

        SpringApplication.run(App.class, args);
    }
}
