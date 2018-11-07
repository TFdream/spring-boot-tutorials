package io.dreamstudio.springboot.rabbitmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 符号#：匹配一个或者多个词 lazy.# 可以匹配 lazy.irs或者lazy.irs.cor
 * 符号*：只能匹配一个词 lazy.* 可以匹配 lazy.irs或者lazy.cor
 * @author Ricky Fung
 */
@SpringBootApplication
public class ProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApp.class, args);
    }
}
