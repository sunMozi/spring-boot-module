package com.webdemo.Dao.impl;


import com.webdemo.Dao.LogDao;
import com.webdemo.utils.MyIoUtils;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author moZiA
 * @date 2025/5/6 10:01
 * @description
 */
@Repository
public class LogDaoImpl implements LogDao {

  @Resource
  private MyIoUtils myIoUtils;

  @Override
  public List<String> getLogData() {
    return myIoUtils.getFileData("log.txt");
  }
}