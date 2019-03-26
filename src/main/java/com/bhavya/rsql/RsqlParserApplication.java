package com.bhavya.rsql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RsqlParserApplication {

  @Value("${spring.datasource.username}") private static String userName;

  public static void main(String[] args) {
    SpringApplication.run(RsqlParserApplication.class, args);
  }

}
