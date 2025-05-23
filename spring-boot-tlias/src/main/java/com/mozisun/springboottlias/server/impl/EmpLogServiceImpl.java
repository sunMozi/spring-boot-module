package com.mozisun.springboottlias.server.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mozisun.springboottlias.mapper.EmpLogMapper;
import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.EmpLog;
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


  @Async
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  @Override
  public void insertLog(EmpLog empLog) {
    empLogMapper.insert(empLog);
  }

  @Override
  public PageResult<EmpLog> page(PageQuery query) {

    PageHelper.startPage(query.getPage(), query.getPageSize());
    List<EmpLog> empLogs = empLogMapper.selectEmpLogList();
    PageInfo<EmpLog> pageInfo = new PageInfo<>(empLogs);
    return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
  }
}