package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.Dto.StudentDto;
import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.StudentVo;
import com.mozisun.springboottlias.server.StudentServer;
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
 * @author moZiA
 * @date 2025/5/17 18:06
 * @description
 */
@RestController
@RequestMapping("students")
public class StudentController {

  @Resource
  private StudentServer studentServer;

  @DeleteMapping("{ids}")
  public Result<?> delById(@PathVariable Integer[] ids) {
    studentServer.delById(ids);
    return Result.success();
  }


  @PostMapping
  public Result<?> addStudent(@RequestBody StudentDto student) {
    studentServer.addStudent(student);
    return Result.success();
  }


  @PutMapping("/violation/{id}/{score}")
  public Result<?> putViolation(@PathVariable Integer id, @PathVariable Short score) {
    studentServer.putViolation(id, score);
    return Result.success();
  }


  @PutMapping
  public Result<?> putStudent(@RequestBody StudentDto student) {
    studentServer.putStudent(student);
    return Result.success();
  }

  @GetMapping("{id}")
  public Result<Student> getById(@PathVariable Integer id) {
    return Result.success(studentServer.getById(id));
  }


  @GetMapping
  public Result<PageResult<StudentVo>> page(StudentQuery query) {
    return Result.success(studentServer.page(query));
  }


}