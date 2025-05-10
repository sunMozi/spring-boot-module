package com.springbootmybatis.mapper.sql;


import org.apache.ibatis.jdbc.SQL;

/**
 * @author moZiA
 * @date 2025/5/10 16:13
 * @description
 */
public class UserMapperSqlProvider {

  /**
   * @author MOZI
   */
  public String getUserById(Integer id) {
    if (id == null && id < 0) {
      throw new IllegalArgumentException("id<UNK>");
    }
    return new SQL().SELECT("*").FROM("user").WHERE("id = #{id}").toString();
  }


  public String getUserByUsernameAndPassword(String username, String password) {
    return new SQL() {{
      SELECT("*");
      FROM("user");
      WHERE("username = #{username} AND password = #{password}");
    }}.toString();
  }


}