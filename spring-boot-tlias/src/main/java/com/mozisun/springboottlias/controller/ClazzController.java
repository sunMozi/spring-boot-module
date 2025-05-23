package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.model.Dos.ClazzListDo;
import com.mozisun.springboottlias.model.Dto.ClazzPageQuery;
import com.mozisun.springboottlias.model.entiry.Clazz;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.server.ClazzService;
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

/**
 * @author moZiA
 * @date 2025/5/11 19:49
 * @description
 */
@RestController
@RequestMapping("clazzs")
public class ClazzController {

  @Resource
  private ClazzService clazzService;


  @GetMapping("list")
  public Result<List<ClazzListDo>> list() {
    return Result.success(clazzService.list());
  }


  @PutMapping
  public Result<?> putClazz(@RequestBody Clazz clazz) {
    clazzService.putClazz(clazz);
    return Result.success();
  }

  @GetMapping("{id}")
  public Result<Clazz> getById(@PathVariable Integer id) {
    return Result.success(clazzService.getById(id));
  }


  @DeleteMapping("{id}")
  public Result<?> delById(@PathVariable Integer id) {
    clazzService.delById(id);
    return Result.success();
  }

  @PostMapping
  public Result<?> addClazz(@RequestBody Clazz clazz) {
    clazzService.addClazz(clazz);
    return Result.success();
  }

  @GetMapping
  public Result<PageResult<ClazzListDo>> getClazzList(ClazzPageQuery clazzPageQuery) {
    PageResult<ClazzListDo> clazzList = clazzService.getClazzList(clazzPageQuery);
    return Result.success(clazzList);
  }


}