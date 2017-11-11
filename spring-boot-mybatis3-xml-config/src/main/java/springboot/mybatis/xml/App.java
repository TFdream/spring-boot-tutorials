package springboot.mybatis.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan(basePackages = "com.mindflow.springboot.mybatis.mapper")
public class App {

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
