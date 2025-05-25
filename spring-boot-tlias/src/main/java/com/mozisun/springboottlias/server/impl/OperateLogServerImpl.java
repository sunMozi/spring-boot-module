package com.mozisun.springboottlias.server.impl;


import com.mozisun.springboottlias.mapper.OperateLogMapper;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import com.mozisun.springboottlias.server.OperateLogServer;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/23 17:52
 * @description
 */
@Service
public class OperateLogServerImpl implements OperateLogServer {

  @Resource
  private OperateLogMapper operateLogMapper;

  @Override
  @Async
  public void insertOperateLog(OperateLog build) {
    operateLogMapper.insertOperateLog(build);
  }
}