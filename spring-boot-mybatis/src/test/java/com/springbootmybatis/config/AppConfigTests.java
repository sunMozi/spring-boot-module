package com.springbootmybatis.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("config")
class AppConfigTests {

  @Resource
  private AppConfig appConfig;

  @Test
  void getUrl() {
    String url = appConfig.getUrl();
    System.out.println(url);
  }

  @Test
  void getUsername() {
    String username = appConfig.getUsername();
    System.out.println(username);
  }

  @Test
  void getPassword() {
    String password = appConfig.getPassword();
    System.out.println(password);
  }
}