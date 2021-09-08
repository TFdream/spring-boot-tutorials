package io.dreamstudio.springboot.prometheus.config;

import io.dreamstudio.springboot.prometheus.DynamicThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Ricky Fung
 */
@Configuration
public class ThreadPoolConfiguration {
    
    @Bean
    public DynamicThreadPoolExecutor dynamicThreadPoolExecutor() {
        return new DynamicThreadPoolExecutor("dtp",2, 5, 5, TimeUnit.MINUTES, new ArrayBlockingQueue<>(200));
    }
}
