package io.dreamstudio.springboot.redis.receiver;

import com.alibaba.fastjson.JSON;
import io.dreamstudio.springboot.redis.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author Ricky Fung
 */
public class DemoReceiver implements MessageListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = StringRedisSerializer.UTF_8.deserialize(message.getChannel());

        String body = StringRedisSerializer.UTF_8.deserialize(message.getBody());

        UserDTO userDTO = JSON.parseObject(body, UserDTO.class);

        logger.info("Receive channel:{}, body:{}", channel, body);
    }
}
