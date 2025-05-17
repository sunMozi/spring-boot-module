package com.mozisun.springboottlias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootTliasApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootTliasApplication.class, args);
  }

}
