package com.webdemo.server;

import com.webdemo.pojo.User;
import java.util.List;

/**
 * @author MoZi
 * @createTime 2025/5/5 11:28
 */
public interface UserServer {
  List<User> getUserList();
}
