package com.mozisun.springboottlias.mapper.sql;


import com.mozisun.springboottlias.model.Dto.ClazzPageQuery;
import com.mozisun.springboottlias.model.entiry.Clazz;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/11 19:48
 * @description
 */
public class ClazzSqlProvider {

  public String selectClazzListByClazzName(String name) {
    return new SQL() {{
      SELECT("*");
      FROM("clazz");
      WHERE("name  = #{name}");
    }}.toString();
  }


  public String updateClazz(Clazz clazz) {
    return new SQL() {{
      UPDATE("clazz");
      if (clazz.getName() != null) {
        SET("name = #{name}");
      }
      if (clazz.getRoom() != null) {
        SET("room = #{room}");
      }
      if (clazz.getBeginDate() != null) {
        SET("begin_date = #{beginDate}");
      }
      if (clazz.getEndDate() != null) {
        SET("end_date = #{endDate}");
      }
      if (clazz.getMasterId() != null) {
        SET("master_id = #{masterId}");
      }
      if (clazz.getSubject() != null) {
        SET("subject = #{subject}");
      }
      if (clazz.getCreateTime() != null) {
        SET("create_time = #{createTime}");
      }
      if (clazz.getUpdateTime() != null) {
        SET("update_time = #{updateTime}");
      }
      WHERE("id = #{id}");
    }}.toString();
  }


  public String selectClazzById() {
    return new SQL() {{
      SELECT("*");
      FROM("clazz");
      WHERE("id = #{id}");
    }}.toString();
  }

  public String deleteById() {
    return new SQL() {{
      DELETE_FROM("clazz");
      WHERE("id = #{id}");
    }}.toString();
  }

  public String insertClazz(Clazz clazz) {
    return new SQL() {{
      INSERT_INTO("clazz");
      if (clazz.getName() != null) {
        VALUES("name", "#{name}");
      }
      if (clazz.getRoom() != null) {
        VALUES("room", "#{room}");
      }
      if (clazz.getBeginDate() != null) {
        VALUES("begin_date", "#{beginDate}");
      }
      if (clazz.getEndDate() != null) {
        VALUES("end_date", "#{endDate}");
      }
      if (clazz.getMasterId() != null) {
        VALUES("master_id", "#{masterId}");
      }
      if (clazz.getSubject() != null) {
        VALUES("subject", "#{subject}");
      }
      if (clazz.getCreateTime() != null) {
        VALUES("create_time", "#{createTime}");
      }
      if (clazz.getUpdateTime() != null) {
        VALUES("update_time", "#{updateTime}");
      }
    }}.toString();
  }

  public String selectClazzList(final Map<String, Object> params) {
    final ClazzPageQuery query = (ClazzPageQuery) params.get("clazzPageQuery");
    return new SQL() {{
      SELECT("c.id as id",
             "c.name as name",
             "c.room as room",
             "c.begin_date as beginDate",
             "c.end_date as endDate",
             "c.master_id as masterId",
             "c.create_time as createTime",
             "c.update_time as updateTime",
             "e.name as masterName");
      FROM("clazz as c");
      LEFT_OUTER_JOIN("emp e ON e.id = c.master_id");
      buildWhereClause(this, query);
      buildOrderByClause(this, query);
    }}.toString();
  }


  private void buildWhereClause(SQL sql, ClazzPageQuery query) {
    if (query.getName() != null && !query.getName().isEmpty()) {
      sql.WHERE("c.name LIKE CONCAT('%', #{clazzPageQuery.name}, '%')");
    }
    if (query.getGender() != null) {
      sql.WHERE("c.gender = #{clazzPageQuery.gender}");
    }
    if (query.getBegin() != null && query.getEnd() != null) {
      sql.WHERE("c.end_date BETWEEN #{clazzPageQuery.begin} AND #{clazzPageQuery.end}");
    }
  }

  private void buildOrderByClause(SQL sql, ClazzPageQuery query) {
    sql.ORDER_BY("c.update_time DESC");
  }
}