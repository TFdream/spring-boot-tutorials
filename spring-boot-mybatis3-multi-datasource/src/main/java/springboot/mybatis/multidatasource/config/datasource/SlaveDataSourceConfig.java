package springboot.mybatis.multidatasource.config.datasource;

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
@MapperScan(basePackages = SlaveDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDataSourceConfig {
    static final String PACKAGE = "springboot.mybatis.multidatasource.mapper.slave";
    static final String MAPPER_LOCATION = "classpath:mapper/slave/*.xml";

    @Value("${spring.datasource.slave.url}")
    private String url;

    @Value("${spring.datasource.slave.username}")
    private String user;

    @Value("${spring.datasource.slave.password}")
    private String password;

    @Value("${spring.datasource.slave.driverClassName}")
    private String driverClass;

    @Bean(name = "slaveDataSource")
    public DataSource clusterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(50);
        return dataSource;
    }

    @Bean(name = "slaveTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "slaveSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("slaveDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SlaveDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
