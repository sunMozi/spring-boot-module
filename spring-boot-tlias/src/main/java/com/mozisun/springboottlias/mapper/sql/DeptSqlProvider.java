package com.mozisun.springboottlias.mapper.sql;


import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/11 11:24
 * @description
 */
public class DeptSqlProvider {

  public String updateDept() {

    return new SQL() {{
      UPDATE("dept");
      SET("name = #{name}");
      SET("update_time = #{updateTime}");
      WHERE("id = #{id}");
    }}.toString();

  }


  public String selectDeptById() {
    return new SQL() {{
      SELECT("*");
      FROM("dept");
      WHERE("id = #{id}");
    }}.toString();
  }

  public String insertDept() {
    return new SQL() {{
      INSERT_INTO("dept");
      VALUES("name", "#{name}");
      VALUES("create_time", "#{createTime}");
      VALUES("update_time", "#{updateTime}");
    }}.toString();
  }


  public String deleteById() {
    return new SQL() {{
      DELETE_FROM("DEPT");
      WHERE("id = #{id}");
    }}.toString();
  }


  public String selectDeptList() {
    return new SQL() {{
      SELECT("*");
      FROM("dept");
    }}.toString();
  }


}