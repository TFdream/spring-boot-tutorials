package io.dreamstudio.springboot.rabbitmq.producer.web;

import io.dreamstudio.springboot.rabbitmq.producer.configuration.ProducerConfig;
import io.dreamstudio.springboot.rabbitmq.contract.model.OrderDTO;
import io.dreamstudio.springboot.rabbitmq.contract.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api")
public class MessageController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/fanout/send")
    public UserDTO sendFanout(@RequestParam("id") Long id, @RequestParam("name") String name,
                              @RequestParam("password") String password, @RequestParam("age") Integer age) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName(name);
        userDTO.setPassword(password);
        userDTO.setAge(age);
        userDTO.setBirthday(new Date());
        userDTO.setPoints(new BigDecimal("1000.2342"));
        rabbitTemplate.convertAndSend(ProducerConfig.FOO_FANOUT_EXCHANGE, "", userDTO);
        logger.info("发送fanout消息成功");
        return userDTO;
    }

    @GetMapping("/topic/send")
    public OrderDTO sendTopic(@RequestParam("id") Long id, @RequestParam("name") String name,
                              @RequestParam("address") String address, @RequestParam("mobile") String mobile) {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(id);
        orderDTO.setReceiverName(name);
        orderDTO.setReceiverAddress(address);
        orderDTO.setReceiverMobile(mobile);
        orderDTO.setOrderTime(new Date());
        rabbitTemplate.convertAndSend(ProducerConfig.ORDER_TOPIC_EXCHANGE, ProducerConfig.ORDER_CREATE_ROUTING_KEY, orderDTO);
        logger.info("发送topic消息成功");
        return orderDTO;
    }
}
