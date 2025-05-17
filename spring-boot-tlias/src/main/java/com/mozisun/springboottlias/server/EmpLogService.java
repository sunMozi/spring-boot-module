package com.mozisun.springboottlias.server;


import com.mozisun.springboottlias.model.entiry.EmpLog;

/**
 * @author moZiA
 * @date 2025/5/17 9:11
 * @description
 */
public interface EmpLogService {
  //记录新增员工日志
  void insertLog(EmpLog empLog);
}