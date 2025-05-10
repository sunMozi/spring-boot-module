package com.webdemo.Dao.impl;


import com.webdemo.Dao.DeptDao;
import com.webdemo.utils.MyIoUtils;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author moZiA
 * @date 2025/5/5 17:12
 * @description
 */
@Slf4j
@Repository
public class DeptDaoImpl implements DeptDao {

  @Resource
  private MyIoUtils myIoUtils;


  @Override
  public List<String> getDeptData() {
    return myIoUtils.getFileData("dept.txt");
  }
}