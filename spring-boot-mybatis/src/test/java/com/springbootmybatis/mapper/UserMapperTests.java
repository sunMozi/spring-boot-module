package com.springbootmybatis.mapper;

import com.springbootmybatis.pojo.User;
import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("mybatis user Dao 接口测试")
public class UserMapperTests {

  @Resource
  private UserMapper userMapper;

  public static Stream<User> userProvider() {
    return Stream.of(new User(null, "admin", "123456", "管理员", 19),
                     new User(null, "liuhua", "123456", "小花", 90),
                     new User(null, "mogua", "123456", "麻瓜", 13),
                     new User(null, "xiaolou", "123456", "小楼", 42),
                     new User(null, "yeye", "123456", "夜夜", 22));
  }

  @Test
  @DisplayName("获取所有用户")
  public void testSelectAll() {
    List<User> users = userMapper.selectAll();
    Assertions.assertNotNull(users);
    users.forEach(System.out::println);
  }


  @ParameterizedTest
  @ValueSource(ints = {1, 10, -1})
  @DisplayName("根据用户id删除数据")
  public void testDeleteById(Integer id) {
    Integer i = userMapper.deleteById(id);
    Assertions.assertNotNull(i);
  }

  @ParameterizedTest
  @MethodSource("userProvider")
  @DisplayName("添加用户")
  public void testInsertUser(User user) {
    Integer row = userMapper.insertUser(user);
    Assertions.assertNotNull(row);
    Assertions.assertEquals(1, row);
  }

  @Test
  @DisplayName("更新用户")
  public void testUpdateUser() {
    User user = User.builder().id(2).username("daqiao").password("123456").name("大乔").build();
    Integer row = userMapper.updateUser(user);
    Assertions.assertNotNull(row);
    Assertions.assertEquals(1, row);
  }

  @Test
  @DisplayName("根据id 查询 user")
  public void testSelectUserById() {
    User user = userMapper.selectUserById(2);
    Assertions.assertNotNull(user);
    System.out.println(user);
  }

  @Test
  @DisplayName("根据username 和 password 查询 user")
  public void testSelectUserByUsernameAndPassword() {
    User user = userMapper.selectUserByUsernameAndPassword("admin", "123456");
    Assertions.assertNotNull(user);
    System.out.println(user);
  }


}