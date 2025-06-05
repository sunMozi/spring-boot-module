package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.Dos.EmpListDo;
import com.mozisun.springboottlias.model.Dto.AddEmpDto;
import com.mozisun.springboottlias.model.Dto.EmpPageQuery;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.EmpExprVO;
import com.mozisun.springboottlias.server.EmpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("emps")
@Tag(name = "员工管理", description = "员工信息的增删改查接口")
public class EmpController {

  @Resource
  private EmpService empService;

  @Operation(summary = "批量删除员工", description = "根据员工ID数组批量删除员工")
  @DeleteMapping
  public Result<?> delById(@Parameter(description = "员工ID数组", required = true) @RequestParam Integer[] ids) {
    empService.delById(ids);
    return Result.success();
  }

  @Operation(summary = "更新员工信息", description = "根据员工ID更新员工详细信息")
  @PutMapping
  public Result<?> putEmp(@RequestBody @Valid AddEmpDto addEmpDto) {
    empService.putEmp(addEmpDto);
    return Result.success();
  }

  @Operation(summary = "根据ID获取员工详情", description = "查询员工及其扩展信息")
  @GetMapping("/{id}")
  public Result<EmpExprVO> getById(@Parameter(description = "员工ID", required = true) @PathVariable Integer id) {
    EmpExprVO result = empService.getEmpExprById(id);
    return Result.success(result);
  }

  @Operation(summary = "新增员工", description = "添加新的员工信息")
  @PostMapping
  public Result<?> add(@RequestBody @Valid AddEmpDto addEmpDto) {
    empService.addEmp(addEmpDto);
    return Result.success();
  }

  @Operation(summary = "获取员工简要列表", description = "返回所有员工的简要信息列表")
  @GetMapping("list")
  public Result<List<Emp>> list() {
    return Result.success(empService.list());
  }

  @Operation(summary = "分页查询员工信息", description = "根据分页参数查询员工详细信息列表")
  @GetMapping
  public Result<PageResult<EmpListDo>> empAll(EmpPageQuery empPageQuery) {
    log.info("查询所有员工信息: {}", empPageQuery);
    PageResult<EmpListDo> page = empService.page(empPageQuery);
    return Result.success(page);
  }

}
