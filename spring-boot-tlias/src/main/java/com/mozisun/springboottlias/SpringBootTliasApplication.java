package com.mozisun.springboottlias;

import com.mozisun.springboottlias.properties.AliOSSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableConfigurationProperties(AliOSSProperties.class)
public class SpringBootTliasApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootTliasApplication.class, args);
  }

}
