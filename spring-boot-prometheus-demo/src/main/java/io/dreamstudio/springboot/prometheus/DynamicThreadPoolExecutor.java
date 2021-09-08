package io.dreamstudio.springboot.prometheus;

import io.micrometer.core.instrument.util.NamedThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ricky Fung
 */
public class DynamicThreadPoolExecutor extends ThreadPoolExecutor {
    private static final AtomicInteger SEQUENCE = new AtomicInteger(1);
    private static final String DEFAULT_PREFIX = "dynamic-pool";
    /**
     * 线程池名称
     */
    private String name;
    
    public DynamicThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        this(genDefaultPoolName(), corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
    
    public DynamicThreadPoolExecutor(String name, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue) {
        this(name, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new NamedThreadFactory(name));
    }
    
    public DynamicThreadPoolExecutor(String name, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        this(name, corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, new AbortPolicy());
    }
    
    public DynamicThreadPoolExecutor(String name, int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory,
            RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    //=======
    private static String genDefaultPoolName() {
        int seq = SEQUENCE.getAndIncrement();
        return String.format("%s-%s", DEFAULT_PREFIX, seq);
    }
}
