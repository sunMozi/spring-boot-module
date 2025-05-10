package com.webdemo.server;

import com.webdemo.pojo.Log;
import java.util.List;

/**
 * @author MoZi
 * @createTime 2025/5/6 9:59
 */
public interface LogServer {
  List<Log> getLogList();
}
