package com.webdemo.Dao;

import com.webdemo.pojo.User;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author MoZi
 * @createTime 2025/5/5 11:30
 */

public interface UserDao {

  List<String> getUserData();
}
