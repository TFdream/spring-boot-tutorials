package io.dreamstudio.springboot.prometheus.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

/**
 * @author Ricky Fung
 */
@Component
public class SampleBean {
    private final Counter counter;

    public SampleBean(MeterRegistry registry) {
        this.counter = registry.counter("gn.beat.counter");
    }

    public void handleMessage(String message) {
        this.counter.increment();
        // handle message implementation
    }
}