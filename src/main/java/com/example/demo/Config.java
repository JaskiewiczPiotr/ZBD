package com.example.demo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

///@SuppressWarnings({"unused", "PublicField"})
@Configuration
public class Config {
    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/students");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("!Query");
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        return dataSourceBuilder.build();

    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }
/*
    @EventListener(ApplicationReadyEvent.class)
    public void doInit(){
        String sql = "CREATE TABLE aeh_students (name varchar(255), lastname varchar(255));";
        getJdbcTemplate().update(sql);
        String sql1 = "CREATE TABLE test_aeh_students (name varchar(255), lastname varchar(255));";
        getJdbcTemplate().update(sql1);
    }
*/
}
