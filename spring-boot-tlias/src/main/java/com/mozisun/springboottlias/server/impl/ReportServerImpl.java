package com.mozisun.springboottlias.server.impl;


import com.mozisun.springboottlias.header.enums.DegreeEnum;
import com.mozisun.springboottlias.header.enums.Role;
import com.mozisun.springboottlias.mapper.ReportMapper;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.ClazzAndDateVo;
import com.mozisun.springboottlias.model.vo.EmpJobDataVo;
import com.mozisun.springboottlias.model.vo.KeyAndValueVO;
import com.mozisun.springboottlias.model.vo.StudentDegreeCountVO;
import com.mozisun.springboottlias.server.ReportServer;
import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/18 19:59
 * @description
 */
@Service
public class ReportServerImpl implements ReportServer {

  @Resource
  private ReportMapper reportMapper;

  @Override
  public Result<?> empGenderData() {
    List<KeyAndValueVO> result = new ArrayList<>();
    result.add(new KeyAndValueVO("男性员工", reportMapper.selectEmpGenderData(1)));
    result.add(new KeyAndValueVO("女性员工", reportMapper.selectEmpGenderData(2)));
    return Result.success(result);
  }


  @Override
  public Result<?> empJobData() {
    List<EmpJobDataVo> result = reportMapper.selectEmpJobData();

    List<String> jobList = result.stream()
                                 .map(vo -> Role.getNameByCode(vo.getJob()))
                                 .collect(Collectors.toList());

    List<Integer> dataList = result.stream()
                                   .map(EmpJobDataVo::getValue)
                                   .collect(Collectors.toList());

    Map<String, Object> map = new HashMap<>();

    map.put("jobList", jobList);
    map.put("dataList", dataList);

    return Result.success(map);
  }

  @Override
  public Result<?> studentDegreeData() {
    Map<Integer, Integer> degreeCountMap = reportMapper.selectAllStudentDegreeData()
                                                       .stream()
                                                       .collect(Collectors.toMap(
                                                           StudentDegreeCountVO::getDegree,
                                                           StudentDegreeCountVO::getCount));

    List<KeyAndValueVO> result = Arrays.stream(DegreeEnum.values())
                                       .map(degree -> new KeyAndValueVO(degree.getName(),
                                                                        degreeCountMap.getOrDefault(
                                                                            degree.getCode(),
                                                                            0)))
                                       .toList();

    return Result.success(result);
  }

  @Override
  public Result<?> studentCountData() {
    List<ClazzAndDateVo> result = reportMapper.selectStudentCountData();
    Map<String, List<?>> map = new HashMap<>();
    map.put("clazzList", result.stream().map(

        clazzAndDateVo -> {
          if (clazzAndDateVo.getClazzName() == null) {
            return "未分配班级";
          } else {
            return clazzAndDateVo.getClazzName();
          }
        }).toList());
    map.put("dataList", result.stream().map(ClazzAndDateVo::getStudentCount).toList());
    return Result.success(map);
  }
}