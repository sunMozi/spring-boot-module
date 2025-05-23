package com.mozisun.springboottlias.header;


import com.mozisun.springboottlias.model.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author moZiA
 * @date 2025/5/19 15:03
 * @description
 */
@Slf4j
@RestControllerAdvice
@Controller
public class GlobalExceptionHandler {

  @ExceptionHandler
  public Result<String> ex(Exception e) {
    log.error("运行时异常: {}", e.getMessage());
    e.printStackTrace();
    return Result.error("对不起,操作失败,请联系管理员");
  }

}