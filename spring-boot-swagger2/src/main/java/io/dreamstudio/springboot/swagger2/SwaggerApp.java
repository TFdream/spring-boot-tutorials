package io.dreamstudio.springboot.swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot与swagger2 集成.<br>
 * 启动服务后访问: http://localhost:8080/swagger-ui.html
 * @author Ricky Fung
 */
@SpringBootApplication
public class SwaggerApp {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApp.class, args);
    }
}
