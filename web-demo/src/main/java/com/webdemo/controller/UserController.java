package com.webdemo.controller;


import com.webdemo.pojo.User;
import com.webdemo.server.impl.UserServerImpl;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/4 18:23
 * @description
 */
@RestController("user")
public class UserController {

  @Resource
  private UserServerImpl userServerImpl;

  @GetMapping("list")
  public List<User> list() {
    return userServerImpl.getUserList();
  }






/*  @RequestMapping("/list")
  public List<User> getUser() {
    ArrayList<User> userList = new ArrayList<>();
    String fileName = "user.txt";
    InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
    IoUtil.readLines(in, StandardCharsets.UTF_8, (LineHandler) line -> {
      String[] split = line.split(",");
      User user = new User();
      user.setId(Integer.valueOf(split[0]));
      user.setUsername(split[1]);

      user.setPassword(split[2]);
      user.setName(split[3]);
      user.setAge(Integer.valueOf(split[4]));
      LocalDateTime parse = LocalDateTime.parse(split[5],
                                                ofPattern("yyyy-MM-dd HH:mm:ss"));
      user.setUpdateTime(parse);*//**//*
      userList.add(user);
    });
    return userList;
  }*/

}