package io.dreamstudio.springboot.hikaricp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SpringBoot整合HikariCP数据库连接池.<br>
 * HikariCP: http://brettwooldridge.github.io/HikariCP/
 * @author Ricky Fung
 */
@EnableTransactionManagement // 开启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
public class HikariCPApp {

    public static void main(String[] args) {
        SpringApplication.run(HikariCPApp.class, args);
    }
}
