package io.dreamstudio.springboot.redis.config;

import io.dreamstudio.springboot.redis.constant.PubSubConstant;
import io.dreamstudio.springboot.redis.receiver.DemoReceiver;
import io.dreamstudio.springboot.redis.receiver.SimpleReceiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ricky Fung
 */
@Configuration
public class RedisListenerConfigure {

    @Bean
    public RedisMessageListenerContainer objectListenerContainer(RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        List<ChannelTopic> topics = Arrays.asList(new ChannelTopic(PubSubConstant.CHAT_ROOM));
        container.addMessageListener(objectMessageListenerAdapter(), topics);
        return container;
    }

    @Bean
    public MessageListenerAdapter objectMessageListenerAdapter() {
        return new MessageListenerAdapter(demoReceiver());
    }

    @Bean
    public DemoReceiver demoReceiver() {
        return new DemoReceiver();
    }

    //--------
    @Bean
    public RedisMessageListenerContainer simpleListenerContainer(RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        List<ChannelTopic> topics = Arrays.asList(new ChannelTopic(PubSubConstant.NEWS_CHANNEL));
        container.addMessageListener(simpleMessageListenerAdapter(), topics);
        return container;
    }

    @Bean
    public MessageListenerAdapter simpleMessageListenerAdapter() {
        return new MessageListenerAdapter(simpleReceiver());
    }

    @Bean
    public SimpleReceiver simpleReceiver() {
        return new SimpleReceiver();
    }
}
