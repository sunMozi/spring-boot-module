package com.mozisun.springboottlias.mapper;


import com.mozisun.springboottlias.mapper.sql.StudentSqlProvider;
import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.vo.StudentVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author moZiA
 * @date 2025/5/17 18:12
 * @description
 */
@Mapper
public interface StudentMapper {

  @SelectProvider(type = StudentSqlProvider.class, method = "selectStudentList")
  List<StudentVo> selectStudentList(@Param("query") StudentQuery query);
}