package com.mozisun.springboottlias.mapper.sql;


import com.mozisun.springboottlias.model.Dto.EmpPageQuery;
import com.mozisun.springboottlias.model.entiry.Emp;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/14 9:55
 * @description
 */
public class EmpSqlProvider {


  public String deleteEmpByIds(final Map<String, Object> params) {
    final Integer[] ids = (Integer[]) params.get("ids");
    return new SQL() {{
      DELETE_FROM("emp");
      if (ids != null && ids.length > 0) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ids.length; i++) {
          if (i > 0) sb.append(",");
          sb.append("#{ids[").append(i).append("]}");
        }
        WHERE("id IN (" + sb.toString() + ")");
      }
    }}.toString();
  }


  public String updateEmp(final Map<String, Object> params) {
    final Emp emp = (Emp) params.get("emp");
    return new SQL() {{
      UPDATE("emp");
      buildSetClause(this, emp);
      WHERE("id = #{emp.id}");
    }}.toString();
  }

  private void buildSetClause(SQL sql, Emp emp) {
    if (emp != null) {
      if (emp.getUsername() != null) {
        sql.SET("username = #{emp.username}");
      }
      if (emp.getPassword() != null) {
        sql.SET("password = #{emp.password}");
      }
      if (emp.getName() != null) {
        sql.SET("name = #{emp.name}");
      }
      if (emp.getGender() != null) {
        sql.SET("gender = #{emp.gender}");
      }
      if (emp.getPhone() != null) {
        sql.SET("phone = #{emp.phone}");
      }
      if (emp.getJob() != null) {
        sql.SET("job = #{emp.job}");
      }
      if (emp.getSalary() != null) {
        sql.SET("salary = #{emp.salary}");
      }
      if (emp.getImage() != null) {
        sql.SET("image = #{emp.image}");
      }
      if (emp.getEntryDate() != null) {
        sql.SET("entry_date = #{emp.entryDate}");
      }
      if (emp.getDeptId() != null) {
        sql.SET("dept_id = #{emp.deptId}");
      }
      sql.SET("update_time = #{emp.createTime}");
      sql.SET("create_time = #{emp.createTime}");
    }
  }


  public String insertEmp(final Map<String, Object> params) {
    final Emp emp = (Emp) params.get("emp");
    return new SQL() {{
      INSERT_INTO("emp");
      // 动态添加字段（仅当字段值非空时）
      if (emp.getUsername() != null) {
        VALUES("username", "#{emp.username}");
      }
      if (emp.getPassword() != null) {
        VALUES("password", "#{emp.password}");
      }
      if (emp.getName() != null) {
        VALUES("name", "#{emp.name}");
      }
      if (emp.getGender() != null) {
        VALUES("gender", "#{emp.gender}");
      }
      if (emp.getPhone() != null) {
        VALUES("phone", "#{emp.phone}");
      }
      if (emp.getJob() != null) {
        VALUES("job", "#{emp.job}");
      }
      if (emp.getSalary() != null) {
        VALUES("salary", "#{emp.salary}");
      }
      if (emp.getImage() != null) {
        VALUES("image", "#{emp.image}");
      }
      if (emp.getEntryDate() != null) {
        VALUES("entry_date", "#{emp.entryDate}");
      }
      if (emp.getDeptId() != null) {
        VALUES("dept_id", "#{emp.deptId}");
      }
      if (emp.getCreateTime() != null) {
        VALUES("create_time", "#{emp.createTime}");
      }
      if (emp.getUpdateTime() != null) {
        VALUES("update_time", "#{emp.updateTime}");
      }
    }}.toString();
  }

  public String selectEmpList() {
    return new SQL() {{
      SELECT("*");
      FROM("emp");
    }}.toString();
  }

  public String selectEmpWithDept(final Map<String, Object> params) {
    System.out.println("params:" + params);
    final EmpPageQuery query = (EmpPageQuery) params.get("empPageQuery");
    return new SQL() {{
      SELECT("e.id as id",
             "e.name",
             "e.gender",
             "e.image",
             "d.name AS deptName",
             "e.job as job",
             "e.entry_date",
             "e.update_time");
      FROM("emp e");
      LEFT_OUTER_JOIN("dept d ON e.dept_id = d.id");

      buildWhereClause(this, query);

      applyOrderBy(this, query);
    }}.toString();
  }


  public String selectEmpCount(final Map<String, Object> params) {
    final EmpPageQuery query = (EmpPageQuery) params.get("empPageQuery");
    return new SQL() {{
      SELECT("COUNT(1)");
      FROM("emp e");
      LEFT_OUTER_JOIN("dept d ON e.dept_id = d.id");

      buildWhereClause(this, query);
    }}.toString();
  }

  private void buildWhereClause(SQL sql, EmpPageQuery query) {
    if (query.getName() != null && !query.getName().isEmpty()) {
      sql.WHERE("e.name LIKE CONCAT('%', #{empPageQuery.name}, '%')");
    }
    if (query.getGender() != null) {
      sql.WHERE("e.gender = #{empPageQuery.gender}");
    }
    if (query.getBegin() != null && query.getEnd() != null) {
      sql.WHERE("e.entry_date BETWEEN #{empPageQuery.begin} AND #{empPageQuery.end}");
    }
  }

  private void applyOrderBy(SQL sql, EmpPageQuery query) {
    sql.ORDER_BY("e.update_time DESC");
  }


}