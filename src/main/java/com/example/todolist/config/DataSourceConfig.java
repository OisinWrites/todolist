package com.example.todolist.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

    @Value("${JAWSDB_ORANGE_URL}")
    private String dbUrl;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        String[] urlParts = dbUrl.split("@");
        String[] credsAndHost = urlParts[0].split("//")[1].split(":");
        String[] hostAndDb = urlParts[1].split("/");

        String username = credsAndHost[0];
        String password = credsAndHost[1];
        String host = hostAndDb[0];
        String database = hostAndDb[1];

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + host + "/" + database);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
