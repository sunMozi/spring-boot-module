package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.ReportServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 报表相关接口
 * @author moZiA
 * @date 2025/5/18 19:57
 */
@Tag(name = "报表模块", description = "员工和学生相关统计报表接口")
@RestController
@RequestMapping("report")
public class ReportController {

  @Resource
  private ReportServer reportServer;

  @Operation(summary = "员工性别统计数据", description = "获取员工性别分布的统计数据")
  @GetMapping("empGenderData")
  public Result<?> empGenderData() {
    return reportServer.empGenderData();
  }

  @Operation(summary = "员工职位统计数据", description = "获取员工职位分布的统计数据")
  @GetMapping("empJobData")
  public Result<?> empJobData() {
    return reportServer.empJobData();
  }

  @Operation(summary = "学生学历统计数据", description = "获取学生学历层次的统计数据")
  @GetMapping("studentDegreeData")
  public Result<?> studentDegreeData() {
    return reportServer.studentDegreeData();
  }

  @Operation(summary = "学生数量统计数据", description = "获取学生数量的时间序列统计数据")
  @GetMapping("studentCountData")
  public Result<?> studentCountData() {
    return reportServer.studentCountData();
  }

}
