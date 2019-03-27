package com.bhavya.rsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
public class RsqlParserApplication {
  public static void main(String[] args) {
    SpringApplication.run(RsqlParserApplication.class, args);
  }
}
