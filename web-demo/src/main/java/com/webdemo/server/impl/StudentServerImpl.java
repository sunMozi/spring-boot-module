package com.webdemo.server.impl;


import com.webdemo.Dao.StudentDao;
import com.webdemo.pojo.Student;
import com.webdemo.server.StudentServer;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/6 10:21
 * @description
 */
@Service
public class StudentServerImpl implements StudentServer {


  @Resource
  private StudentDao studentDao;

  @Override
  public List<Student> getStudentList() {
    return studentDao.getStudentList().stream().map(this::StrToStudent).toList();
  }

  private Student StrToStudent(String str) {
    String[] split = str.split(",");
    return Student.builder()
                  .name(split[0])
                  .weight(Integer.valueOf(split[1]))
                  .number(Integer.valueOf(split[2]))
                  .build();
  }
}