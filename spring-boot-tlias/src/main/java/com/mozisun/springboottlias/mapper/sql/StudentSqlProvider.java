package com.mozisun.springboottlias.mapper.sql;


import com.mozisun.springboottlias.model.Dto.StudentQuery;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/17 18:15
 * @description
 */
public class StudentSqlProvider {

  public String selectStudentList(final Map<String, Object> params) {
    final StudentQuery query = (StudentQuery) params.get("query");
    return new SQL() {{
      SELECT("student.*","clazz.name as ClazzName");
      FROM("student");
      LEFT_OUTER_JOIN("clazz on student.clazz_id = clazz.id");
      if (query != null) {
        if (query.getName() != null) {
          WHERE("student.name LIKE CONCAT('%', #{query.name}, '%')");
      }
        if (query.getDegree() != null) {
          WHERE("student.degree = #{query.degree}");
        }
        if (query.getClazzId() != null) {
          WHERE("student.clazz_id = #{query.clazzId}");
        }
      }
    }}.toString();
  }


}