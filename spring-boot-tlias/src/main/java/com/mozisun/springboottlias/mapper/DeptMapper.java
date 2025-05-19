package com.mozisun.springboottlias.mapper;


import com.mozisun.springboottlias.mapper.sql.DeptSqlProvider;
import com.mozisun.springboottlias.model.entiry.Dept;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * @author moZiA
 * @date 2025/5/11 11:22
 * @description
 */
@Mapper
public interface DeptMapper {

  @UpdateProvider(type = DeptSqlProvider.class, method = "updateDept")
  void updateDept(Dept dept);

  @SelectProvider(type = DeptSqlProvider.class, method = "selectDeptById")
  Dept selectDeptById(Integer id);

  @InsertProvider(type = DeptSqlProvider.class, method = "insertDept")
  void insertDept(Dept dept);

  @DeleteProvider(type = DeptSqlProvider.class, method = "deleteById")
  void deleteById(Integer id);

  @SelectProvider(type = DeptSqlProvider.class, method = "selectDeptList")
  List<Dept> selectDeptList();
}