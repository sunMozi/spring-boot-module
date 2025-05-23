package com.mozisun.springboottlias.mapper;


import com.mozisun.springboottlias.model.entiry.EmpLog;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

  @Select("select * from emp_log")
  List<EmpLog> selectEmpLogList();
}