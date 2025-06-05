package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.Dos.ClazzListDo;
import com.mozisun.springboottlias.model.Dto.ClazzPageQuery;
import com.mozisun.springboottlias.model.entiry.Clazz;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.ClazzService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "班级管理", description = "提供班级的增删改查接口")
@RestController
@RequestMapping("clazzs")
public class ClazzController {

  @Resource
  private ClazzService clazzService;

  @Operation(summary = "获取全部班级列表（简要）")
  @GetMapping("list")
  public Result<List<ClazzListDo>> list() {
    return Result.success(clazzService.list());
  }

  @Operation(summary = "新增班级")
  @PostMapping
  public Result<?> addClazz(@RequestBody Clazz clazz) {
    clazzService.addClazz(clazz);
    return Result.success();
  }

  @Operation(summary = "修改班级信息")
  @PutMapping
  public Result<?> putClazz(@RequestBody Clazz clazz) {
    clazzService.putClazz(clazz);
    return Result.success();
  }

  @Operation(summary = "根据 ID 获取班级详情")
  @GetMapping("{id}")
  public Result<Clazz> getById(@Parameter(description = "班级ID") @PathVariable Integer id) {
    return Result.success(clazzService.getById(id));
  }

  @Operation(summary = "根据 ID 删除班级")
  @DeleteMapping("{id}")
  public Result<?> delById(@Parameter(description = "班级ID") @PathVariable Integer id) {
    clazzService.delById(id);
    return Result.success();
  }

  @Operation(summary = "分页查询班级列表")
  @GetMapping
  public Result<PageResult<ClazzListDo>> getClazzList(ClazzPageQuery clazzPageQuery) {
    PageResult<ClazzListDo> clazzList = clazzService.getClazzList(clazzPageQuery);
    return Result.success(clazzList);
  }

}
