package com.mozisun.springboottlias.mapper;

import com.mozisun.springboottlias.mapper.sql.ReportSqlProvider;
import com.mozisun.springboottlias.model.vo.ClazzAndDateVo;
import com.mozisun.springboottlias.model.vo.EmpJobDataVo;
import com.mozisun.springboottlias.model.vo.StudentDegreeCountVO;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @author MoZi
 * @createTime 2025/5/18 20:00
 */
@Mapper
public interface ReportMapper {

  @Select("select count(*) from emp where gender = #{gender}")
  Integer selectEmpGenderData(Integer gender);

  @Select("select job, count(*) as value from emp group by job order by value ")
  List<EmpJobDataVo> selectEmpJobData();
  
  @Select("SELECT degree, COUNT(*) as count FROM student WHERE degree IS NOT NULL GROUP BY degree")
  List<StudentDegreeCountVO> selectAllStudentDegreeData();

  @SelectProvider(type = ReportSqlProvider.class, method = "selectStudentCountData")
  List<ClazzAndDateVo> selectStudentCountData();

}
