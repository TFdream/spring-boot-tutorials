package springboot.tutorials.mybatis.multidatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author Ricky Fung
 */
@Configuration
@MapperScan(basePackages = BarDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "barSqlSessionFactory")
public class BarDataSourceConfig {
    static final String PACKAGE = "springboot.tutorials.mybatis.multidatasource.mapper.slave";
    static final String MAPPER_LOCATION = "classpath:mapper/bar/*.xml";

    @Value("${spring.datasource.bar.url}")
    private String url;

    @Value("${spring.datasource.bar.username}")
    private String user;

    @Value("${spring.datasource.bar.password}")
    private String password;

    @Value("${spring.datasource.bar.driverClassName}")
    private String driverClass;

    @Bean(name = "barDataSource")
    public DataSource barDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(50);
        return dataSource;
    }

    @Bean(name = "barSqlSessionFactory")
    public SqlSessionFactory barSqlSessionFactory(@Qualifier("barDataSource") DataSource barDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(barDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(BarDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager barTransactionManager(@Qualifier("barDataSource") DataSource barDataSource) {
        return new DataSourceTransactionManager(barDataSource);
    }

}
