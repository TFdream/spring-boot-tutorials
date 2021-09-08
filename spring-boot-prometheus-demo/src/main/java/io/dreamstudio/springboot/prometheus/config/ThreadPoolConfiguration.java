package io.dreamstudio.springboot.prometheus.config;

import io.dreamstudio.springboot.prometheus.dynamic.DynamicThreadPoolExecutor;
import io.dreamstudio.springboot.prometheus.dynamic.ResizableCapacityLinkedBlockingQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author Ricky Fung
 */
@Configuration
public class ThreadPoolConfiguration {
    
    @Bean
    public DynamicThreadPoolExecutor dynamicThreadPoolExecutor() {
        return new DynamicThreadPoolExecutor("dynamic-pool",2, 8,
                5, TimeUnit.MINUTES, new ResizableCapacityLinkedBlockingQueue<>(50));
    }
}
