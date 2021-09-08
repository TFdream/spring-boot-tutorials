package io.dreamstudio.springboot.prometheus.metrics;

import io.dreamstudio.springboot.commons.util.IpUtils;
import io.dreamstudio.springboot.commons.util.RandomUtils;
import io.dreamstudio.springboot.prometheus.dynamic.DynamicThreadPoolExecutor;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Ricky Fung
 */
@Component
public class ThreadPoolMetrics {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    private MeterRegistry registry;
    
    @Resource
    private DynamicThreadPoolExecutor dynamicThreadPoolExecutor;
    
    private AtomicLong counter;
    
    @PostConstruct
    public void init() {
        String ip = IpUtils.getLocalIp();
        this.counter = registry.gauge("tp.taskCount", Tags.of("ip", ip, "poolName", dynamicThreadPoolExecutor.getName()), new AtomicLong(0));
    }
    
    @Scheduled(fixedDelay = 10_000)
    public void scrapeResources() {
        LOG.info("定时抓取线程池信息开始");
        counter.set(dynamicThreadPoolExecutor.getTaskCount());
        
        int random = RandomUtils.nextInt(16, 128);
        for (int i=0; i<random; i++) {
            dynamicThreadPoolExecutor.execute(()->{
                LOG.info("定时任务执行开始, random={}", random);
                try {
                    TimeUnit.MILLISECONDS.sleep(random * 50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOG.info("定时任务执行结束");
            });
        }
        LOG.info("定时抓取线程池信息结束");
    }
}
