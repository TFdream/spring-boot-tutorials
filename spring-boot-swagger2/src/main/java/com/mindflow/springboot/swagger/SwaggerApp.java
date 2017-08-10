package com.mindflow.springboot.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.mindflow.springboot.swagger"})
public class SwaggerApp {

    public static void main( String[] args ) {

        SpringApplication.run(SwaggerApp.class, args);
    }
}
