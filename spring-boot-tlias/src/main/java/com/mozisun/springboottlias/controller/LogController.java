package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.EmpLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 操作日志管理接口
 * 提供系统操作日志的分页查询能力
 *
 * @author moZiA
 * @date 2025/5/19 11:58
 */
@RestController
@RequestMapping("log")
@Tag(name = "日志管理", description = "系统操作日志分页查询接口")
public class LogController {

  @Resource
  private EmpLogService empLogService;

  @Operation(summary = "分页查询操作日志", description = "支持分页参数查询系统操作日志")
  @GetMapping("page")
  public Result<PageResult<OperateLog>> page(PageQuery query) {
    // 这里可以考虑参数校验、默认分页设置等
    return Result.success(empLogService.OperateLogPage(query));
  }

}
