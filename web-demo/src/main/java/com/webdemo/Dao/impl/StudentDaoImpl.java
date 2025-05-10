package com.webdemo.Dao.impl;


import com.webdemo.Dao.StudentDao;
import com.webdemo.utils.MyIoUtils;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author moZiA
 * @date 2025/5/6 10:18
 * @description
 */
@Repository
public class StudentDaoImpl implements StudentDao {


  @Resource
  private MyIoUtils myIoUtils;

  @Override
  public List<String> getStudentList() {
    return myIoUtils.getFileData("rollCall.txt");
  }
}