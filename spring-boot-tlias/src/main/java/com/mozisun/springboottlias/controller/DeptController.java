package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.Dept;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.DeptServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门管理接口
 * 负责部门的增删改查业务逻辑交互
 *
 * @author moZiA
 * @date 2025/5/11 11:22
 */
@Tag(name = "部门管理", description = "部门的创建、更新、查询与删除接口")
@RestController
@RequestMapping("depts")
public class DeptController {

  @Resource
  private DeptServer deptServer;

  @Operation(summary = "更新部门信息", description = "根据部门ID更新部门信息")
  @PutMapping
  public Result<?> putDept(@RequestBody Dept dept) {
    deptServer.putDept(dept);
    return Result.success();
  }

  @Operation(summary = "根据ID获取部门详情", description = "通过部门ID查询对应部门完整信息")
  @GetMapping("/{id}")
  public Result<Dept> getDeptById(@Parameter(description = "部门ID", required = true) @PathVariable Integer id) {
    return Result.success(deptServer.getDeptById(id));
  }

  @Operation(summary = "新增部门", description = "添加一个新的部门")
  @PostMapping
  public Result<?> addDept(@RequestBody Dept dept) {
    deptServer.addDept(dept);
    return Result.success();
  }

  @Operation(summary = "删除部门", description = "根据部门ID删除部门")
  @DeleteMapping
  public Result<?> delById(@Parameter(description = "部门ID", required = true) @RequestParam("id") Integer id) {
    deptServer.delById(id);
    return Result.success();
  }

  @Operation(summary = "查询所有部门", description = "获取全部部门列表")
  @GetMapping("list")
  public Result<PageResult<Dept>> deptAll(PageQuery query) {
    return Result.success(deptServer.deptAll(query));
  }
  @Operation(summary = "查询所有部门", description = "获取全部部门列表")
  @GetMapping
  public Result<List<Dept>> deptList() {
    return Result.success(deptServer.deptList());
  }

}
