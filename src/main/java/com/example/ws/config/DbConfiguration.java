package com.example.ws.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.ws.*")
public class DbConfiguration {

    @Autowired
    private DbConfigurationProperties dbConfigurationProperties;

    @Bean
    public SessionFactory sessionFactory() throws PropertyVetoException {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("com.example.ws.*").addProperties(getHibernateProperties());
        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.format_sql", dbConfigurationProperties.getFormatSql());
        prop.put("hibernate.show_sql", dbConfigurationProperties.getShowSql());
        prop.put("hibernate.dialect", dbConfigurationProperties.getDialect());
        prop.put("hibernate.max_fetch_depth", dbConfigurationProperties.getMaxFetchDepth());
        prop.put("hibernate.jdbc.batch_size", dbConfigurationProperties.getJdbcBatchSize());
        //prop.put("hibernate.default_schema", dbConfigurationProperties.getHibernateDefaultSchema());

        prop.put("hibernate.c3p0.min_size", dbConfigurationProperties.getC3POMinSize());
        prop.put("hibernate.c3p0.max_size", dbConfigurationProperties.getC3POMaxSize());
        prop.put("hibernate.c3p0.max_statements", dbConfigurationProperties.getC3POMaxStatement());
        prop.put("hibernate.c3p0.idle_test_period", dbConfigurationProperties.getC3POIdleTestPeriod());
        return prop;
    }

    @Bean(name = "dataSource")
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(dbConfigurationProperties.getHibernateDriverClassName());
        ds.setJdbcUrl(dbConfigurationProperties.getJdbcUrl());
        ds.setUser(dbConfigurationProperties.getUsername());
        ds.setPassword(dbConfigurationProperties.getPassword());
        ds.setMinPoolSize(new Integer(dbConfigurationProperties.getC3POMinSize()));
        ds.setMaxIdleTime(300000);
        ds.setMaxIdleTimeExcessConnections(300000);
        ds.setAcquireIncrement(1);
        ds.setMaxPoolSize(new Integer(dbConfigurationProperties.getC3POMaxSize()));
        ds.setMaxStatements(new Integer(dbConfigurationProperties.getC3POMaxStatement()));
        return ds;
    }

    @Bean
    public HibernateTransactionManager txManager() throws PropertyVetoException {
        return new HibernateTransactionManager(sessionFactory());
    }
}