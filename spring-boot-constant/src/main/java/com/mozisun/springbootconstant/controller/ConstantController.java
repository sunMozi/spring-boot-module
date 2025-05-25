package com.mozisun.springbootconstant.controller;


import com.mozisun.springbootconstant.model.Constant;
import com.mozisun.springbootconstant.service.ConstantService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/25 15:18
 * @description
 */
@RestController
@RequestMapping("/api/constants")
public class ConstantController {


  @GetMapping("/{category}")
  public List<Constant> getConstants(@PathVariable String category) {
    return ConstantService.listByCategory(category);
  }

  @GetMapping("/{category}/{code}/name")
  public String getConstantName(@PathVariable String category, @PathVariable String code) {
    return ConstantService.getName(category, code);
  }
}