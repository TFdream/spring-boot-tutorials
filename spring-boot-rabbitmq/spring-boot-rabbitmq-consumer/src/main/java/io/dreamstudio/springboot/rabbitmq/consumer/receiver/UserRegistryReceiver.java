package io.dreamstudio.springboot.rabbitmq.consumer.receiver;

import io.dreamstudio.springboot.rabbitmq.consumer.configuration.ConsumerConfig;
import io.dreamstudio.springboot.rabbitmq.contract.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Ricky Fung
 */
@Component
@RabbitListener(queues = ConsumerConfig.FOO_QUEUE)
public class UserRegistryReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(UserDTO user) {
        logger.info("接收到用户注册消息: "+user);
    }
}
