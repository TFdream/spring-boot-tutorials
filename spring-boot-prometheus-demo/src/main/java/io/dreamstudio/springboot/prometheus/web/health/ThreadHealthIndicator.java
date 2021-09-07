package io.dreamstudio.springboot.prometheus.web.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Ricky Fung
 */
@Component
public class ThreadHealthIndicator extends AbstractHealthIndicator {
    @Resource
    private ThreadPoolExecutor threadPoolExecutor;
    
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 使用 builder 来创建健康状态信息
        // 如果你throw 了一个 exception，那么status 就会被置为DOWN，异常信息会被记录下来
        builder.up()
                .withDetail("tp.coreSize", threadPoolExecutor.getCorePoolSize())
                .withDetail("tp.maxSize", threadPoolExecutor.getMaximumPoolSize())
                .withDetail("tp.poolSize", threadPoolExecutor.getPoolSize())
                .withDetail("tp.largestPoolSize", threadPoolExecutor.getLargestPoolSize())
                .withDetail("tp.activeCount", threadPoolExecutor.getActiveCount())
                .withDetail("tp.completedTaskCount", threadPoolExecutor.getCompletedTaskCount())
                .withDetail("tp.taskCount", threadPoolExecutor.getTaskCount());
    }
}
