package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.Dos.EmpListDo;
import com.mozisun.springboottlias.model.Dto.AddEmpDto;
import com.mozisun.springboottlias.model.Dto.EmpPageQuery;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.model.vo.EmpExprVO;
import com.mozisun.springboottlias.server.EmpService;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/14 9:16
 * @description
 */
@Slf4j
@RestController
@RequestMapping("emps")
public class EmpController {

  @Resource
  private EmpService empService;

  @GetMapping("/{id}")
  public Result<EmpExprVO> getById(@PathVariable Integer id) {
    EmpExprVO result = empService.getEmpExprById(id);
    return Result.success(result);
  }


  @PostMapping
  public Result<?> add(@RequestBody AddEmpDto addEmpDto) {
    empService.addEmp(addEmpDto);
    return Result.success();
  }


  @GetMapping("list")
  public Result<List<Emp>> list() {
    return Result.success(empService.list());
  }


  @GetMapping
  public Result<PageResult<EmpListDo>> empAll(EmpPageQuery empPageQuery) {
    log.info("查询所有员工信息: {}", empPageQuery);
    PageResult<EmpListDo> page = empService.page(empPageQuery);
    return Result.success(page);
  }


}