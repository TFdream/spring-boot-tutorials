package io.dreamstudio.springboot.commons.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ricky Fung
 */
public class NamedThreadFactory implements ThreadFactory {
    private final AtomicInteger sequence = new AtomicInteger(1);
    private final String prefix;
    private final boolean daemon;
    
    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }
    
    public NamedThreadFactory(String prefix, boolean daemon) {
        this.prefix = prefix;
        this.daemon = daemon;
    }

    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        int seq = this.sequence.getAndIncrement();
        thread.setName(String.format("%s-%s", this.prefix, seq));
        thread.setDaemon(daemon);
        return thread;
    }
}
