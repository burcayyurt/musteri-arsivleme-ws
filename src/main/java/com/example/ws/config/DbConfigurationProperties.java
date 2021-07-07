package com.example.ws.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("hibernate")
public class DbConfigurationProperties {

    @Value("${hibernate.formatSql}")
    private @Getter @Setter
    String formatSql;
    @Value("${hibernate.showSql}")
    private @Getter @Setter String showSql;
    @Value("${hibernate.dialect}")
    private @Getter @Setter String dialect;
    @Value("${hibernate.maxFetchDepth}")
    private @Getter @Setter String maxFetchDepth;
    @Value("${hibernate.jdbcBatchSize}")
    private @Getter @Setter String jdbcBatchSize;
    @Value("${hibernate.jdbcUrl}")
    private @Getter @Setter String jdbcUrl;
    @Value("${hibernate.username}")
    private @Getter @Setter String username;
    @Value("${hibernate.password}")
    private @Getter @Setter String password;
    @Value("${hibernate.hibernateDriverClassName}")
    private @Getter @Setter String hibernateDriverClassName;
    @Value("${hibernate.c3POMinSize}")
    private @Getter @Setter String c3POMinSize;
    @Value("${hibernate.c3POMaxSize}")
    private @Getter @Setter String c3POMaxSize;
    @Value("${hibernate.c3POTimeout}")
    private @Getter @Setter String c3POTimeout;
    @Value("${hibernate.c3POMaxStatement}")
    private @Getter @Setter String c3POMaxStatement;
    @Value("${hibernate.c3POIdleTestPeriod}")
    private @Getter @Setter String c3POIdleTestPeriod;

}