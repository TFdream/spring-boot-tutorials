package io.dreamstudio.springboot.prometheus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Ricky Fung
 */
@Configuration
public class ThreadPoolConfiguration {
    
    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(2, 5, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(200));
    }
}
