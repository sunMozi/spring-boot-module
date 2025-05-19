package com.mozisun.springboottlias.server.impl;


import com.mozisun.springboottlias.enums.Role;
import com.mozisun.springboottlias.mapper.ReportMapper;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.EmpGenderDataVo;
import com.mozisun.springboottlias.model.vo.EmpJobDataVo;
import com.mozisun.springboottlias.server.ReportServer;
import jakarta.annotation.Resource;
import java.util.ArrayList;
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
    List<EmpGenderDataVo> result = new ArrayList<>();
    result.add(new EmpGenderDataVo("男性员工", reportMapper.selectEmpGenderData(1)));
    result.add(new EmpGenderDataVo("女性员工", reportMapper.selectEmpGenderData(2)));
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
}