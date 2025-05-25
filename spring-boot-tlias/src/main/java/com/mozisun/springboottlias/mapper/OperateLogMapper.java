package com.mozisun.springboottlias.mapper;

import com.mozisun.springboottlias.mapper.sql.OperateLogMapperProvider;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import java.util.List;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author MoZi
 * @createTime 2025/5/23 16:50
 */
@Mapper
public interface OperateLogMapper {

  @InsertProvider(type = OperateLogMapperProvider.class, method = "insertOperateLog")
  void insertOperateLog(@Param("log") OperateLog log);

  @Select("select * from operate_log")
  List<OperateLog> selectEmpLogList();
}
