package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.entiry.Dept;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.DeptServer;
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
 * @author moZiA
 * @date 2025/5/11 11:22
 * @description
 */
@RestController
@RequestMapping("depts")
public class DeptController {

  @Resource
  private DeptServer deptServer;

  @PutMapping
  public Result<?> putDept(@RequestBody Dept dept) {
    deptServer.putDept(dept);
    return Result.success();
  }


  @GetMapping("/{id}")
  public Result<Dept> getDeptById(@PathVariable Integer id) {
    return Result.success(deptServer.getDeptById(id));
  }


  @PostMapping
  public Result<?> addDept(@RequestBody Dept dept) {
    deptServer.addDept(dept);
    return Result.success();
  }

  @DeleteMapping
  public Result<?> delById(@RequestParam("id") Integer id) {
    deptServer.delById(id);
    return Result.success();
  }

  @GetMapping
  public Result<List<Dept>> deptAll() {
    List<Dept> deptList = deptServer.deptAll();
    return Result.success(deptList);
  }


}