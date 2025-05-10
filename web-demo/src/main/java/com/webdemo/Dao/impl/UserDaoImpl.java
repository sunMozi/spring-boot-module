package com.webdemo.Dao.impl;


import com.webdemo.Dao.UserDao;
import com.webdemo.utils.MyIoUtils;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author moZiA
 * @date 2025/5/5 11:31
 * @description
 */
@Slf4j
@Repository
public class UserDaoImpl implements UserDao {

  @Resource
  private MyIoUtils myIoUtils;

  @Override
  public List<String> getUserData() {
    return myIoUtils.getFileData("user.txt");
  }

}