package io.dreamstudio.springboot.druid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot整合阿里巴巴Druid数据库连接池.<br>
 * druid: https://github.com/alibaba/druid
 * @author Ricky Fung
 */
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
public class DruidApp {

    public static void main(String[] args) {
        SpringApplication.run(DruidApp.class, args);
    }
}
