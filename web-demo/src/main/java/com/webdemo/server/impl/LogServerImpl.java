package com.webdemo.server.impl;


import com.webdemo.Dao.LogDao;
import com.webdemo.pojo.Log;
import com.webdemo.server.LogServer;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/6 9:59
 * @description
 */
@Service
public class LogServerImpl implements LogServer {

  @Resource
  private LogDao logDao;

  @Override
  public List<Log> getLogList() {
    return logDao.getLogData().stream().map(this::strTOLog).toList();

  }

  private Log strTOLog(String str) {
    String[] split = str.split(",");
    return Log.builder()
              .operateEmpName(split[0])
              .operateTime(split[1])
              .className(split[2])
              .methodName(split[3])
              .costTime(split[4])
              .methodParams(split[5])
              .returnValue(split[6])
              .build();
  }
}