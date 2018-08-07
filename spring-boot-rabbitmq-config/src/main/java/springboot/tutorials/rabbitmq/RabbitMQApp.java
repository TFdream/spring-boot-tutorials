package springboot.tutorials.rabbitmq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 */
@SpringBootApplication
@MapperScan(basePackages = "com.mindflow.springboot.mybatis.mapper")
public class RabbitMQApp {

    public static void main(String[] args) {

        SpringApplication.run(RabbitMQApp.class, args);
    }
}
