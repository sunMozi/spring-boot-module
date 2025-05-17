package com.mozisun.springboottlias.mapper.sql;


import com.mozisun.springboottlias.model.entiry.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author moZiA
 * @date 2025/5/17 9:10
 * @description
 */
@Mapper
public interface EmpLogMapper {
  //插入日志
  @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
  void insert(EmpLog empLog);
}