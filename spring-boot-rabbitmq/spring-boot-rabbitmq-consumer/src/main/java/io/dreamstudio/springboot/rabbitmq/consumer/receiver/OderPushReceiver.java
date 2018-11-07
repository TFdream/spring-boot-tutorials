package io.dreamstudio.springboot.rabbitmq.consumer.receiver;

import io.dreamstudio.springboot.rabbitmq.consumer.configuration.ConsumerConfig;
import io.dreamstudio.springboot.rabbitmq.contract.model.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Ricky Fung
 */
@Component
@RabbitListener(queues = ConsumerConfig.ORDER_QUEUE)
public class OderPushReceiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(OrderDTO order) {
        logger.info("接收到订单状态变更消息: "+order);
    }
}
