package com.webdemo.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.webdemo.pojo.User;
import com.webdemo.server.impl.UserServerImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("2 用户业务层测试")
public class UserServerTests {

  private UserServer userServer;

  @BeforeEach
  public void init() {
    userServer = new UserServerImpl();
  }

  @Test
  @DisplayName("2.1 获取用户列表")
  public void getUserList() {
    List<User> userList = userServer.getUserList();
    assertNotNull(userList);
    assertEquals(8, userList.size(), "测试不通过");
  }
}