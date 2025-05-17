package com.mozisun.springboottlias.mapper;

import com.mozisun.springboottlias.mapper.sql.EmpExprSqlProvider;
import com.mozisun.springboottlias.model.entiry.EmpExpr;
import java.util.List;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author MoZi
 * @createTime 2025/5/14 16:56
 */
@Mapper
public interface EmpExprMapper {

  @InsertProvider(type = EmpExprSqlProvider.class, method = "insertBatch")
  void insertBatch(@Param("empExprs") List<EmpExpr> empExprs);


  @Select("select * from emp_expr where emp_id = #{id}")
  List<EmpExpr> selectEmpExprByEmpId(Integer id);
}
