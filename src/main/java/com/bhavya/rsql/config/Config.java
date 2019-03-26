package com.bhavya.rsql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

  @Bean(name = "dataSource") public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl("jdbc:h2:file:~/test");
    dataSource.setUsername("sa");
    dataSource.setPassword("");

    return dataSource;
  }

}
