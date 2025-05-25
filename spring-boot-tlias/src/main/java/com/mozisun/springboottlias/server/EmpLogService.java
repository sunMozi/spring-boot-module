package com.mozisun.springboottlias.server;


import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.EmpLog;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import com.mozisun.springboottlias.model.result.PageResult;

/**
 * @author moZiA
 * @date 2025/5/17 9:11
 * @description
 */
public interface EmpLogService {
  //记录新增员工日志
  void insertLog(EmpLog empLog);


  PageResult<OperateLog> OperateLogPage(PageQuery query);
}