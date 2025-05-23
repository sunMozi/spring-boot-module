package com.mozisun.springboottlias.mapper;


import com.mozisun.springboottlias.mapper.sql.StudentSqlProvider;
import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.vo.StudentVo;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * @author moZiA
 * @date 2025/5/17 18:12
 * @description
 */
@Mapper
public interface StudentMapper {

  @SelectProvider(type = StudentSqlProvider.class, method = "selectStudentList")
  List<StudentVo> selectStudentList(@Param("query") StudentQuery query);

  @Select("select * from student where id = #{id}")
  Student selectStudentById(Integer id);

  @UpdateProvider(type = StudentSqlProvider.class, method = "updateStudent")
  void updateStudent(@Param("student") Student student);


  @Select("select * from student where clazz_id = #{clazzId}")
  List<Student> selectStudentByClazzId();

  @InsertProvider(type = StudentSqlProvider.class, method = "insertStudent")
  void insertStudent(@Param("student") Student student);

  @DeleteProvider(type = StudentSqlProvider.class, method = "deleteStudentByIdBatch")
  void deleteStudentByIdBatch(@Param("ids") Integer[] ids);
}