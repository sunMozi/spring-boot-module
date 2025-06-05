package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.Dto.StudentDto;
import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.StudentVo;
import com.mozisun.springboottlias.server.StudentServer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生信息管理接口
 *
 * @author moZiA
 * @date 2025/5/17 18:06
 */
@Tag(name = "学生管理模块", description = "学生信息的增删改查及违纪处理接口")
@RestController
@RequestMapping("students")
public class StudentController {

  @Resource
  private StudentServer studentServer;

  @Operation(summary = "删除学生", description = "根据学生ID数组批量删除学生")
  @DeleteMapping("{ids}")
  public Result<?> delById(
      @Parameter(description = "学生ID数组，多个ID用逗号分隔") @PathVariable Integer[] ids) {
    studentServer.delById(ids);
    return Result.success();
  }

  @Operation(summary = "新增学生", description = "添加新的学生信息")
  @PostMapping
  public Result<?> addStudent(@RequestBody StudentDto student) {
    studentServer.addStudent(student);
    return Result.success();
  }

  @Operation(summary = "更新学生违纪分数", description = "根据学生ID更新违纪分数")
  @PutMapping("/violation/{id}/{score}")
  public Result<?> putViolation(
      @Parameter(description = "学生ID") @PathVariable Integer id,
      @Parameter(description = "违纪分数") @PathVariable Short score) {
    studentServer.putViolation(id, score);
    return Result.success();
  }

  @Operation(summary = "修改学生信息", description = "更新学生详细信息")
  @PutMapping
  public Result<?> putStudent(@RequestBody StudentDto student) {
    studentServer.putStudent(student);
    return Result.success();
  }

  @Operation(summary = "获取学生信息", description = "根据学生ID获取学生详细信息")
  @GetMapping("{id}")
  public Result<Student> getById(@Parameter(description = "学生ID") @PathVariable Integer id) {
    return Result.success(studentServer.getById(id));
  }

  @Operation(summary = "分页查询学生", description = "根据条件分页查询学生信息")
  @GetMapping
  public Result<PageResult<StudentVo>> page(StudentQuery query) {
    return Result.success(studentServer.page(query));
  }

}
