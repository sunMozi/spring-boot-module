package com.webdemo.controller;

import com.webdemo.pojo.Result;
import com.webdemo.server.impl.LogServerImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

  @Resource
  private LogServerImpl logServerImpl;

  @RequestMapping("/logs")
  private Result list() {
    return Result.success(logServerImpl.getLogList());
  }

}
