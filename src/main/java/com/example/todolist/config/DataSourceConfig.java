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

        try {
            // Extracting username, password, host, and database name from dbUrl
            String[] urlParts = dbUrl.split("@");
            String[] credsAndProtocol = urlParts[0].split("//")[1].split(":");
            String[] hostAndDb = urlParts[1].split("/");

            String username = credsAndProtocol[0];
            String password = credsAndProtocol[1];
            String host = hostAndDb[0];
            String database = hostAndDb[1];

            String jdbcUrl = "jdbc:mysql://" + host + "/" + database;

            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl(jdbcUrl);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JAWSDB_ORANGE_URL", e);
        }

        return dataSource;
    }
}
