package com.webdemo.Dao;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeptDaoTests {

  @Resource
  private DeptDao deptDao;


  @Test
  public void getDeptData() {
    List<String> deptData = deptDao.getDeptData();
    deptData.forEach(System.out::println);
  }
}