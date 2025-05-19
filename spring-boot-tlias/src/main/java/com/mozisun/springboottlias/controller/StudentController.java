package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.StudentVo;
import com.mozisun.springboottlias.server.StudentServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping
  public Result<PageResult<StudentVo>> page(StudentQuery query) {
    return Result.success(studentServer.page(query));
  }


}