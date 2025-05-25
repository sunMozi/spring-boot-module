package com.mozisun.springboottlias.server.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mozisun.springboottlias.mapper.EmpLogMapper;
import com.mozisun.springboottlias.mapper.OperateLogMapper;
import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.EmpLog;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.server.EmpLogService;
import jakarta.annotation.Resource;
import java.util.List;
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

  @Resource
  private OperateLogMapper operateLogMapper;


  @Async
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public void insertLog(EmpLog empLog) {
    empLogMapper.insert(empLog);
  }


  @Override
  public PageResult<OperateLog> OperateLogPage(PageQuery query) {
    PageHelper.startPage(query.getPage(), query.getPageSize());
    List<OperateLog> operateLogs = operateLogMapper.selectEmpLogList();
    Page<OperateLog> page = (Page<OperateLog>) operateLogs;
    return new PageResult<>(page.getTotal(), page.getResult());
  }
}