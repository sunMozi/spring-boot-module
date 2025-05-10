package com.webdemo.Dao;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@DisplayName("dept 数据 读取")
class DeptDaoTest {


  @Resource
  private DeptDao deptDao;

  @Test
  void getDeptData() {
    List<String> deptData = deptDao.getDeptData();
    deptData.forEach(System.out::println);
  }
}