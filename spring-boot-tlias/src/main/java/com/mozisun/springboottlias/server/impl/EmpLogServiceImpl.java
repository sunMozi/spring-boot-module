package com.mozisun.springboottlias.server.impl;


import com.mozisun.springboottlias.mapper.EmpLogMapper;
import com.mozisun.springboottlias.model.entiry.EmpLog;
import com.mozisun.springboottlias.server.EmpLogService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author moZiA
 * @date 2025/5/17 9:11
 * @description
 */
@Service
public class EmpLogServiceImpl implements EmpLogService {

  @Resource
  private EmpLogMapper empLogMapper;


  @Async
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public void insertLog(EmpLog empLog) {
    empLogMapper.insert(empLog);
  }
}