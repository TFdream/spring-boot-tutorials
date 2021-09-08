package io.dreamstudio.springboot.prometheus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Ricky Fung
 */
@EnableScheduling
@SpringBootApplication
public class PrometheusApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PrometheusApplication.class, args);
    }
}
