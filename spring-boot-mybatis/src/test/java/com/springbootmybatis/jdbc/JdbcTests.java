package com.springbootmybatis.jdbc;


import com.springbootmybatis.config.AppConfig;
import com.springbootmybatis.pojo.User;
import jakarta.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moZiA
 * @date 2025/5/8 15:40
 * @description
 */
@SpringBootTest
@DisplayName("Jdbc")
public class JdbcTests {

  @Resource
  private AppConfig appConfig;

  @Test
  @DisplayName("Jdbc 连接测试")
  public void testConnection() throws SQLException {
    Connection connection = DriverManager.getConnection(appConfig.getUrl(), appConfig.getUsername(),
                                                        appConfig.getPassword());
    Assertions.assertNotNull(connection);

    Statement statement = connection.createStatement();
    String sql = "SELECT * FROM user WHERE username = 'daqiao' AND password = '123456'";
    ResultSet resultSet = statement.executeQuery(sql);
    User user = null;
    while (resultSet.next()) {
      int id = resultSet.getInt("id");
      String username = resultSet.getString("username");
      String password = resultSet.getString("password");
      String name = resultSet.getString("name");
      Integer age = resultSet.getInt("age");
      user = User.builder()
                 .id(id)
                 .username(username)
                 .password(password)
                 .name(name)
                 .age(age)
                 .build();
    }
    Assertions.assertNotNull(user);
  }

  @Test
  @DisplayName("Jdbc 连接测试")
  public void testInsert() throws SQLException {
    Connection connection = DriverManager.getConnection(appConfig.getUrl(), appConfig.getUsername(),
                                                        appConfig.getPassword());
    Assertions.assertNotNull(connection);

    Statement statement = connection.createStatement();
    String sql = "SELECT * FROM user WHERE username = ? AND password = '123456'";
    ResultSet resultSet = statement.executeQuery(sql);
    User user = null;

    Assertions.assertNotNull(user);
  }


}