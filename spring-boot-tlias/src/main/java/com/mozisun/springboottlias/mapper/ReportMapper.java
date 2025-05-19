package com.mozisun.springboottlias.mapper;

import com.mozisun.springboottlias.model.vo.EmpJobDataVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author MoZi
 * @createTime 2025/5/18 20:00
 */
@Mapper
public interface ReportMapper {

  @Select("select count(*) from emp where gender = #{gender}")
  Integer selectEmpGenderData(Integer gender);

  @Select("select job, count(*) as value from emp group by job")
  List<EmpJobDataVo> selectEmpJobData();
}
