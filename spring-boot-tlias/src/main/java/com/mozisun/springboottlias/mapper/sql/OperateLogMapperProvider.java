package com.mozisun.springboottlias.mapper.sql;


import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/23 16:51
 * @description
 */
public class OperateLogMapperProvider {

  public String insertOperateLog(final Map<String, Object> params) {
    final OperateLog log = (OperateLog) params.get("log");
    return new SQL() {{
      INSERT_INTO("operate_log");
      if (log.getOperateEmpId() != null) {
        VALUES("operate_emp_id", "#{log.operateEmpId}");
      }
      if (log.getOperateTime() != null) {
        VALUES("operate_time", "#{log.operateTime}");
      }
      if (log.getClassName() != null) {
        VALUES("class_name", "#{log.className}");
      }
      if (log.getMethodName() != null) {
        VALUES("method_name", "#{log.methodName}");
      }
      if (log.getMethodParams() != null) {
        VALUES("method_params", "#{log.methodParams}");
      }
      if (log.getReturnValue() != null) {
        VALUES("return_value", "#{log.returnValue}");
      }
      if (log.getCostTime() != null) {
        VALUES("cost_time", "#{log.costTime}");
      }
    }}.toString();
  }


}