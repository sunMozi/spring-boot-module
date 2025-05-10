package com.webdemo.Dao;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTests {

  @Autowired
  private UserDao userDao;

  @Test
  @DisplayName("1.1 获取用户所有信息")
  public void getUserData() {
    List<String> userData = userDao.getUserData();

    Assertions.assertNotNull(userData);
    Assertions.assertEquals(8, userData.size());

  }
}