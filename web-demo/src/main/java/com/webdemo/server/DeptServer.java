package com.webdemo.server;


import com.webdemo.pojo.Dept;
import java.util.List;

/**
 * @author moZiA
 * @date 2025/5/5 17:11
 * @description
 */
public interface DeptServer {
  List<Dept> getDeptList();
}