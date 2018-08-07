package springboot.tutorials.mybatis.multidatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * @author Ricky Fung
 */
@Configuration
@MapperScan(basePackages = FooDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "fooSqlSessionFactory")
public class FooDataSourceConfig {

    static final String PACKAGE = "springboot.tutorials.mybatis.multidatasource.mapper.master";
    static final String MAPPER_LOCATION = "classpath:mapper/foo/*.xml";

    @Value("${spring.datasource.foo.url}")
    private String url;

    @Value("${spring.datasource.foo.username}")
    private String user;

    @Value("${spring.datasource.foo.password}")
    private String password;

    @Value("${spring.datasource.foo.driverClassName}")
    private String driverClass;

    @Bean
    @Primary
    public DataSource fooDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(50);
        dataSource.setMinIdle(0);
        return dataSource;
    }

    @Bean(name = "fooSqlSessionFactory")
    public SqlSessionFactory fooSqlSessionFactory(@Qualifier("fooDataSource") DataSource fooDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(fooDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(FooDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean
    public DataSourceTransactionManager fooTransactionManager(@Qualifier("fooDataSource") DataSource fooDataSource) {
        return new DataSourceTransactionManager(fooDataSource);
    }

}
