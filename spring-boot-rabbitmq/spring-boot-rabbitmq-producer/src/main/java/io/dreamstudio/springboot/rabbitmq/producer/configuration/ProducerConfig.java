package io.dreamstudio.springboot.rabbitmq.producer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ricky Fung
 */
@Configuration
public class ProducerConfig {

    public static final String FOO_FANOUT_EXCHANGE = "foo.fanout.exchange";
    public static final String FOO_QUEUE = "foo.v1.queue";

    //---------
    public static final String ORDER_TOPIC_EXCHANGE = "order.topic.exchange";
    public static final String ORDER_QUEUE = "order.v1.queue";

    public static final String ORDER_CREATE_ROUTING_KEY = "order.create";
    public static final String ORDER_PAY_ROUTING_KEY = "order.pay";
    public static final String ORDER_CANCEL_ROUTING_KEY = "order.cancel";


    //-----------fanout
    @Bean
    public FanoutExchange fooFanoutExchange() {
        return new FanoutExchange(FOO_FANOUT_EXCHANGE);
    }

    @Bean
    public Queue fooQueue() {
        return new Queue(FOO_QUEUE);
    }

    @Bean
    public Binding fooFanoutExchangeBinding() {
        return BindingBuilder.bind(fooQueue()).to(fooFanoutExchange());
    }

    //----------topic
    @Bean
    public TopicExchange orderTopicExchange() {
        return new TopicExchange(ORDER_TOPIC_EXCHANGE);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue(ORDER_QUEUE);
    }

    @Bean
    public Binding orderTopicExchangeBinding() {
        return BindingBuilder.bind(orderQueue()).to(orderTopicExchange()).with("order.*");
    }
}
