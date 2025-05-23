package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.ReportServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/18 19:57
 * @description
 */
@RestController
@RequestMapping("report")
public class ReportController {

  @Resource
  private ReportServer reportServer;


  @GetMapping("empGenderData")
  public Result<?> empGenderData() {
    return reportServer.empGenderData();
  }


  @GetMapping("empJobData")
  public Result<?> empJobData() {
    return reportServer.empJobData();
  }


  @GetMapping("studentDegreeData")
  public Result<?> studentDegreeData() {
    return reportServer.studentDegreeData();
  }

  @GetMapping("studentCountData")
  public Result<?> studentCountData() {
    return reportServer.studentCountData();
  }


}