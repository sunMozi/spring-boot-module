package com.webdemo.server.impl;


import static java.time.format.DateTimeFormatter.ofPattern;

import com.webdemo.Dao.UserDao;
import com.webdemo.pojo.User;
import com.webdemo.server.UserServer;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/5 11:29
 * @description
 */
@Service
public class UserServerImpl implements UserServer {


  @Resource
  private UserDao userDao;


  @Override
  public List<User> getUserList() {
    List<String> userData = userDao.getUserData();
    return userData.stream().map(this::strOfUser).toList();
  }

  private User strOfUser(String str) {
    String[] lineArray = str.split(",");
    return User.builder()
               .id(Integer.valueOf(lineArray[0]))
               .username(lineArray[1])
               .password(lineArray[2])
               .name(lineArray[3])
               .age(Integer.valueOf(lineArray[4]))
               .updateTime(LocalDateTime.parse(lineArray[5], ofPattern("yyyy-MM-dd HH:mm:ss")))
               .build();

  }

}