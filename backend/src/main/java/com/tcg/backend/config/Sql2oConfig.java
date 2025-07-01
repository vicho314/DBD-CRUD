package com.tcg.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

//import javax.sql.DataSource;

@Configuration
public class Sql2oConfig {

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    /*
    @Bean
    public DataSource dataSource() {
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testDB");
        dataSource.setUsername("user");
        dataSource.setPassword("pass");
    }
    */

    @Bean
    public Sql2o sql2o() {
        return new Sql2o(jdbcUrl, username, password);
    }
}
