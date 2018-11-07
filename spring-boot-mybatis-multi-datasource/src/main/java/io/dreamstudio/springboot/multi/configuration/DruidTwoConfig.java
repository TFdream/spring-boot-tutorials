package io.dreamstudio.springboot.multi.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 订单库数据源配置
 * @author Ricky Fung
 */
@Configuration
@MapperScan(basePackages = "io.dreamstudio.springboot.multi.mapper.two",
        sqlSessionFactoryRef = "orderSqlSessionFactory")
public class DruidTwoConfig extends BaseDataSourceConfig {

    static final String MAPPER_LOCATION = "classpath:mapper/two/*.xml";

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("dataSourceTwo") DataSource dataSourceTwo)
            throws Exception {

        return getSqlSessionFactory(dataSourceTwo, MAPPER_LOCATION);
    }

    @Bean(name = "orderTransactionManager")
    public DataSourceTransactionManager orderTransactionManager(@Qualifier("dataSourceTwo") DataSource dataSourceTwo) {
        return new DataSourceTransactionManager(dataSourceTwo);
    }

}
