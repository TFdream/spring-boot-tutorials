package io.dreamstudio.springboot.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring-boot 配置Druid多数据源.<br>
 * druid: https://github.com/alibaba/druid
 * @author Ricky Fung
 */
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
public class MultiDataSourceApp {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApp.class, args);
    }
}
