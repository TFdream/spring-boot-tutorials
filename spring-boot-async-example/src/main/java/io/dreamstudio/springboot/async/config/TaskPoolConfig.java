package io.dreamstudio.springboot.async.config;

import com.iqianjin.lego.tracing.spring.TraceThreadPoolTaskExecutor;
import com.iqianjin.lego.tracing.ttl.TaskDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Ricky Fung
 */
@Configuration
public class TaskPoolConfig {
    private static final Logger LOG = LoggerFactory.getLogger(TaskPoolConfig.class);

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new TraceThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(200);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("taskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    static class MyThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
        @Override
        public void execute(Runnable task) {
            LOG.info("execute task:{}", task);
            super.execute(TaskDecorator.decorate(task));
        }

        @Override
        public Future<?> submit(Runnable task) {
            LOG.info("submit Runnable task:{}", task);
            return super.submit(TaskDecorator.decorate(task));
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            LOG.info("submit Callable task:{}", task);
            return super.submit(TaskDecorator.decorate(task));
        }
    }
}
