package com.springbootmybatis.mapper;


import com.springbootmybatis.pojo.Student;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

  @Select("select * from `student`")
  List<Student> selectAll();


  @Insert("insert into student value (#{id},#{name},#{no},#{gender},#{phone},#{idCard},#{degree},#{graduationDate},#{createTime},#{updateTime})")
  Integer insertStudent(Student student);

//  @Update("update student set no = #{no} , phone = #{phone} , id_card = #{idCard} where id = #{id}")
  Integer updateStudent(Student student);




}
