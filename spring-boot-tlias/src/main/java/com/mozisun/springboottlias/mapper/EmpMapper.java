package com.mozisun.springboottlias.mapper;

import com.github.pagehelper.Page;
import com.mozisun.springboottlias.mapper.sql.EmpSqlProvider;
import com.mozisun.springboottlias.model.Dos.EmpListDo;
import com.mozisun.springboottlias.model.Dto.EmpPageQuery;
import com.mozisun.springboottlias.model.entiry.Emp;
import java.util.List;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author MoZi
 * @createTime 2025/5/14 9:16
 */
@Mapper
public interface EmpMapper {

  @SelectProvider(type = EmpSqlProvider.class, method = "selectEmpWithDept")
  Page<EmpListDo> selectEmpWithDept(@Param("empPageQuery") EmpPageQuery empPageQuery);

  @SelectProvider(type = EmpSqlProvider.class, method = "selectEmpList")
  List<Emp> selectEmpList();


  @InsertProvider(type = EmpSqlProvider.class, method = "insertEmp")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertEmp(@Param("emp") Emp emp);

  @Select("select * from emp where id = #{id}")
  Emp selectEmpById(Integer id);
}
