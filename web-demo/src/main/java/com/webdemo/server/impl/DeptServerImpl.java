package com.webdemo.server.impl;


import com.webdemo.Dao.DeptDao;
import com.webdemo.pojo.Dept;
import com.webdemo.server.DeptServer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/5 17:12
 * @description
 */
@Service
public class DeptServerImpl implements DeptServer {


  @Autowired
  private DeptDao deptDao;

  @Override
  public List<Dept> getDeptList() {
    List<String> deptData = deptDao.getDeptData();
    return deptData.stream().map(this::strToDept).toList();
  }


  private Dept strToDept(String str) {
    String[] split = str.split(",");
    return Dept.builder()
               .id(Integer.parseInt(split[0]))
               .name(split[1])
               .updateTime(LocalDateTime.parse(split[2],
                                               DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
               .build();
  }
}