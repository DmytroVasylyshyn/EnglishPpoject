package com.project.multiligual.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); // Change this based on your database
        dataSource.setUrl("jdbc:postgresql://localhost:5432/multiligual");
        dataSource.setUsername("postgres");
        dataSource.setPassword("06091996");

        return dataSource;
    }
}
