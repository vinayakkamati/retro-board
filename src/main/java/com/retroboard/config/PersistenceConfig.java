package com.retroboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:/Users/admin/Desktop/database/retro_board;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;");
        dataSource.setUsername("username");
        dataSource.setPassword("password");


        return dataSource;
    }
}
