package com.mindflow.springboot.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.mindflow.springboot.restful"})
public class RestfulApp {

    public static void main( String[] args ) throws Exception {

        SpringApplication.run(RestfulApp.class, args);
    }
}
