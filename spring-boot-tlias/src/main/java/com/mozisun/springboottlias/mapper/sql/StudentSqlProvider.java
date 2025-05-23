package com.mozisun.springboottlias.mapper.sql;


import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/17 18:15
 * @description
 */
public class StudentSqlProvider {

  public String deleteStudentByIdBatch(final Map<String, Object> params) {
    final Integer[] ids = (Integer[]) params.get("ids");
    return new SQL() {{
      DELETE_FROM("student");
      WHERE("id IN " + toInClause(ids));
    }}.toString();
  }

  private String toInClause(Integer[] ids) {
    if (ids == null || ids.length == 0) {
      throw new IllegalArgumentException("IDs array must not be null or empty");
    }

    return Arrays.stream(ids).map(String::valueOf).collect(Collectors.joining(",", "(", ")"));
  }

  public String insertStudent(final Map<String, Object> params) {
    final Student student = (Student) params.get("student");
    return new SQL() {{
      INSERT_INTO("student");
      buildValuesClause(this, student);
    }}.toString();
  }

  private void buildValuesClause(SQL sql, Student student) {
    if (student != null) {
      if (student.getName() != null) {
        sql.VALUES("name", "#{student.name}");
      }
      if (student.getNo() != null) {
        sql.VALUES("no", "#{student.no}");
      }
      if (student.getGender() != null) {
        sql.VALUES("gender", "#{student.gender}");
      }
      if (student.getPhone() != null) {
        sql.VALUES("phone", "#{student.phone}");
      }
      if (student.getIdCard() != null) {
        sql.VALUES("id_card", "#{student.idCard}");
      }
      if (student.getIsCollege() != null) {
        sql.VALUES("is_college", "#{student.isCollege}");
      }
      if (student.getAddress() != null) {
        sql.VALUES("address", "#{student.address}");
      }
      if (student.getDegree() != null) {
        sql.VALUES("degree", "#{student.degree}");
      }
      if (student.getGraduationDate() != null) {
        sql.VALUES("graduation_date", "#{student.graduationDate}");
      }
      if (student.getClazzId() != null) {
        sql.VALUES("clazz_id", "#{student.clazzId}");
      }
      if (student.getViolationCount() != null) {
        sql.VALUES("violation_count", "#{student.violationCount}");
      }
      if (student.getViolationScore() != null) {
        sql.VALUES("violation_score", "#{student.violationScore}");
      }
      if (student.getCreateTime() != null) {
        sql.VALUES("create_time", "#{student.createTime}");
      }
      if (student.getUpdateTime() != null) {
        sql.VALUES("update_time", "#{student.updateTime}");
      }
    }
  }

  public String updateStudent(final Map<String, Object> params) {
    final Student student = (Student) params.get("student");
    return new SQL() {{

      UPDATE("student");
      buildSetClause(this, student);
      WHERE("id = #{student.id}");
    }}.toString();
  }

  private void buildSetClause(SQL sql, Student student) {
    if (student != null) {
      if (student.getName() != null) {
        sql.SET("name = #{student.name}");
      }
      if (student.getNo() != null) {
        sql.SET("no = #{student.no}");
      }
      if (student.getGender() != null) {
        sql.SET("gender = #{student.gender}");
      }
      if (student.getPhone() != null) {
        sql.SET("phone = #{student.phone}");
      }
      if (student.getIdCard() != null) {
        sql.SET("id_card = #{student.idCard}");
      }
      if (student.getIsCollege() != null) {
        sql.SET("is_college = #{student.isCollege}");
      }
      if (student.getAddress() != null) {
        sql.SET("address = #{student.address}");
      }
      if (student.getDegree() != null) {
        sql.SET("degree = #{student.degree}");
      }
      if (student.getGraduationDate() != null) {
        sql.SET("graduation_date = #{student.graduationDate}");
      }
      if (student.getClazzId() != null) {
        sql.SET("clazz_id = #{student.clazzId}");
      }
      if (student.getViolationCount() != null) {
        sql.SET("violation_count = #{student.violationCount}");
      }
      if (student.getViolationScore() != null) {
        sql.SET("violation_score = #{student.violationScore}");
      }
      sql.SET("update_time = #{student.updateTime}");

    }
  }

  public String selectStudentList(final Map<String, Object> params) {
    final StudentQuery query = (StudentQuery) params.get("query");
    return new SQL() {{
      SELECT("student.*", "clazz.name as ClazzName");
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
      ORDER_BY("student.update_time DESC");
    }}.toString();
  }


}