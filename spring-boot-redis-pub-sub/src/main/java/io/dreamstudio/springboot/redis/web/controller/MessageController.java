package io.dreamstudio.springboot.redis.web.controller;

import io.dreamstudio.springboot.commons.util.JsonUtils;
import io.dreamstudio.springboot.redis.constant.PubSubConstant;
import io.dreamstudio.springboot.redis.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Ricky Fung
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/publish/simple")
    public String publishSimple(@RequestParam("msg") String msg) {
        logger.info("publish message:{}", msg);

        stringRedisTemplate.convertAndSend(PubSubConstant.NEWS_CHANNEL, msg);
        return "Over";
    }

    @RequestMapping("/publish/bean")
    public String publishObject(@RequestParam("id") Long id) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setName("ricky_"+id);
        userDTO.setAddress("北京市朝阳区银河SOHO");
        userDTO.setBirthday(new Date());

        logger.info("publish message:{}", JsonUtils.toJson(userDTO));

        stringRedisTemplate.convertAndSend(PubSubConstant.NEWS_CHANNEL, JsonUtils.toJson(userDTO));
        return "Over";
    }
}
