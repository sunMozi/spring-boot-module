package com.webdemo.Dao;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@DisplayName("log Data")
class LogDaoTest {

  @Resource
  private LogDao logDao;


  @Test
  @DisplayName("从文件取数据")
  void getLogData() {
    List<String> logData = logDao.getLogData();
    Assertions.assertNotNull(logData);
    Assertions.assertEquals(10, logData.size());
  }
}