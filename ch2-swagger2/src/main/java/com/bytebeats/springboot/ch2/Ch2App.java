package com.bytebeats.springboot.ch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.bytebeats.springboot.ch2"})
public class Ch2App {

    public static void main( String[] args ) {

        SpringApplication.run(Ch2App.class, args);
    }
}
