package io.dreamstudio.springboot.prometheus.web.health;

import io.dreamstudio.springboot.prometheus.DynamicThreadPoolExecutor;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
@Component
public class ThreadHealthIndicator extends AbstractHealthIndicator {
    @Resource
    private DynamicThreadPoolExecutor dynamicThreadPoolExecutor;
    
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 使用 builder 来创建健康状态信息
        // 如果你throw 了一个 exception，那么status 就会被置为DOWN，异常信息会被记录下来
        builder.up()
                .withDetail("tp.name", dynamicThreadPoolExecutor.getName())
                .withDetail("tp.coreSize", dynamicThreadPoolExecutor.getCorePoolSize())
                .withDetail("tp.maxSize", dynamicThreadPoolExecutor.getMaximumPoolSize())
                .withDetail("tp.poolSize", dynamicThreadPoolExecutor.getPoolSize())
                .withDetail("tp.largestPoolSize", dynamicThreadPoolExecutor.getLargestPoolSize())
                .withDetail("tp.activeCount", dynamicThreadPoolExecutor.getActiveCount())
                .withDetail("tp.completedTaskCount", dynamicThreadPoolExecutor.getCompletedTaskCount())
                .withDetail("tp.taskCount", dynamicThreadPoolExecutor.getTaskCount());
    }
}
