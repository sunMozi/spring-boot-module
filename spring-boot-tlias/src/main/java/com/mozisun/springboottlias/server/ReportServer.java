package com.mozisun.springboottlias.server;


import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.EmpLog;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;

/**
 * @author moZiA
 * @date 2025/5/18 19:59
 * @description
 */
public interface ReportServer {

  Result<?> empGenderData();

  Result<?> empJobData();

  Result<?> studentDegreeData();

  Result<?> studentCountData();

}