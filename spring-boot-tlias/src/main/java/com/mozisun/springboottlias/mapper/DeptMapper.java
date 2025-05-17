package com.mozisun.springboottlias.mapper;


import com.mozisun.springboottlias.mapper.sql.DeptMapperSqlProvider;
import com.mozisun.springboottlias.model.entiry.Dept;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * @author moZiA
 * @date 2025/5/11 11:22
 * @description
 */
@Mapper
public interface DeptMapper {

  @UpdateProvider(type = DeptMapperSqlProvider.class, method = "updateDept")
  void updateDept(Dept dept);

  @SelectProvider(type = DeptMapperSqlProvider.class, method = "selectDeptById")
  Dept selectDeptById(Integer id);

  @InsertProvider(type = DeptMapperSqlProvider.class, method = "insertDept")
  void insertDept(Dept dept);

  @DeleteProvider(type = DeptMapperSqlProvider.class, method = "deleteById")
  void deleteById(Integer id);

  @SelectProvider(type = DeptMapperSqlProvider.class, method = "selectDeptList")
  List<Dept> selectDeptList();
}