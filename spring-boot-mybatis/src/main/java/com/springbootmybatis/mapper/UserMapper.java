package com.springbootmybatis.mapper;

import com.springbootmybatis.mapper.sql.UserMapperSqlProvider;
import com.springbootmybatis.pojo.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

/**
 * @author MoZi
 * @createTime 2025/5/10 10:14
 *  一般Mybatis 构建操作数据层（dao层）的框架，数据层建包一般叫mapper包。
 *  在mapper包中创建Mapper接口，接口命名规范：一般用实体类名Mapper，比如UserMapper。
 *  接口上使用一个注解@Mapper。
 *  在接口中定义方法：
 *  4.1一般查询的方法以selectXXX开头。
 *  4.2修改方法updateXXX、modifyXXX。
 *  4.3删除delXXX、deleteXX、removeXXX。
 */
@Mapper
public interface UserMapper<T> {

  List<User> selectAll();

  @Delete("delete from `user` where id = #{id}")
  Integer deleteById(@Param("id") Integer id);

  @Insert("insert into user value (null,#{username},#{password},#{name},#{age})")
  Integer insertUser(User user);

  @Update("update user set username = #{username} , password = #{password} , name = #{name} , age = #{age} where id = #{id}")
  Integer updateUser(User user);

  @SelectProvider(type = UserMapperSqlProvider.class, method = "getUserById")
  User selectUserById(Integer id);

  @SelectProvider(type = UserMapperSqlProvider.class, method = "getUserByUsernameAndPassword")
  User selectUserByUsernameAndPassword(@Param("username") String username,
      @Param("password") String password);


}
