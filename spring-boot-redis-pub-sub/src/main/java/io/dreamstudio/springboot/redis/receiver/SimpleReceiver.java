package io.dreamstudio.springboot.redis.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Ricky Fung
 */
public class SimpleReceiver implements MessageListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = StringRedisSerializer.UTF_8.deserialize(message.getChannel());

        String body = StringRedisSerializer.UTF_8.deserialize(message.getBody());

        logger.info("Receive channel:{}, body:{}", channel, body);
    }
}
