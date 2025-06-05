package com.mozisun.springboottlias.controller;

import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.utils.AliOSSUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 通用接口：用于文件上传等公共操作
 */
@Tag(name = "通用接口", description = "提供文件上传等公共能力")
@Controller
// 跨域
@CrossOrigin
public class CommonController {

  @Resource
  private AliOSSUtils aliOSSUtils;

  @Operation(summary = "上传图片", description = "上传图片至阿里云 OSS 并返回访问链接")
  @PostMapping("/upload")
  @ResponseBody
  public Result<String> uploadImage(
      @Parameter(description = "上传的文件", required = true)
      @RequestParam("file") MultipartFile file) throws Exception {

    String url = aliOSSUtils.upload(file);
    return Result.success(url);
  }

}
