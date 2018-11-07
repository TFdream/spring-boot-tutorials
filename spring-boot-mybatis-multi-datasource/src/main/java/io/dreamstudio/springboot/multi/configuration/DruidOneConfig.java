package io.dreamstudio.springboot.multi.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 用户库数据源配置
 * @author Ricky Fung
 */
@Configuration
@MapperScan(basePackages = "io.dreamstudio.springboot.multi.mapper.one",
        sqlSessionFactoryRef = "userSqlSessionFactory")
public class DruidOneConfig extends BaseDataSourceConfig {

    static final String MAPPER_LOCATION = "classpath:mapper/one/*.xml";

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("dataSourceOne") DataSource dataSourceOne)
            throws Exception {
        return getSqlSessionFactory(dataSourceOne, MAPPER_LOCATION);
    }

    @Primary
    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager userTransactionManager(@Qualifier("dataSourceOne") DataSource dataSourceOne) {
        return new DataSourceTransactionManager(dataSourceOne);
    }

}
