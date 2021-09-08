package io.dreamstudio.springboot.prometheus.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 方式二：MeterBinder
 * SpringBoot中提供了MeterBinder接口用于申明与注册meterRegistry。
 * 自定义Metrics只需要实现MeterBinder接口，Spring会自动发现并完成后续的杂活。
 */
@Component
public class MyMetrics implements MeterBinder {
    
    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        //此处添加相关指标
        meterRegistry.gauge("gn.temperature.gauge", Tags.of("site", "SiteA", "cab", "cab01"), new AtomicInteger(37));
    }
}