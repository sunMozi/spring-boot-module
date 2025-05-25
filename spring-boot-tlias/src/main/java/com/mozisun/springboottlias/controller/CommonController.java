package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.aop.anno.OperateLogAnno;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.utils.AliOSSUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author moZiA
 * @date 2025/5/16 15:49
 * @description
 */
@Controller
public class CommonController {

  @Resource
  private AliOSSUtils aliOSSUtils;


  @PostMapping("/upload")
  @ResponseBody
  @OperateLogAnno
  public Result<String> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
    String url = aliOSSUtils.upload(file);
    return Result.success(url);
  }


}