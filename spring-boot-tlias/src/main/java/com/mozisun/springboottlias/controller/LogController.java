package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.EmpLog;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.EmpLogService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/19 11:58
 * @description
 */
@RestController
@RequestMapping("log")
public class LogController {

  @Resource
  private EmpLogService empLogService;

  @GetMapping("page")
  public Result<PageResult<EmpLog>> page(PageQuery query) {
    PageResult<EmpLog> pageResult = empLogService.page(query);
    return Result.success(pageResult);
  }


}