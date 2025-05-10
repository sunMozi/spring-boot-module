package com.webdemo.controller;


import com.webdemo.pojo.Result;
import com.webdemo.server.impl.StudentServerImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/6 10:25
 * @description
 */
@RestController
public class StudentController {

  @Resource
  private StudentServerImpl serverServer;

  @GetMapping("student/list")
  public Result getStudentList() {
    return Result.success(serverServer.getStudentList());
  }
}