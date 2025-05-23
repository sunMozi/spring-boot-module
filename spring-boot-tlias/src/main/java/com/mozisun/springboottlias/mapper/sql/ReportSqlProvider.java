package com.mozisun.springboottlias.mapper.sql;


/**
 * @author moZiA
 * @date 2025/5/19 15:39
 * @description
 */
public class ReportSqlProvider {

  public String selectStudentCountData() {
    return """
        SELECT
          clazz.name AS clazz_name,
          COUNT(student.id) AS student_count\s
        FROM
          clazz \s
          LEFT JOIN student ON clazz.id = student.clazz_id \s
        GROUP BY
          clazz.id, clazz.name\s
        
        ORDER BY student_count;
        """;
  }

}