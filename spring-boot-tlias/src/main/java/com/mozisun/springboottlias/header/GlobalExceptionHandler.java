package com.mozisun.springboottlias.header;


import com.mozisun.springboottlias.model.result.Result;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author moZiA
 * @date 2025/5/19 15:03
 * @description
 */
@Slf4j
@RestControllerAdvice
@Controller
public class GlobalExceptionHandler {

  // 参数校验异常
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Result<String> handleValidation(MethodArgumentNotValidException e) {
    String errorMsg = Objects.requireNonNull(e.getBindingResult().getFieldError())
                             .getDefaultMessage();
    log.warn("参数校验失败: {}", errorMsg);
    return Result.error(errorMsg);
  }


  // 资源未找到（如 Swagger 404）
  @ExceptionHandler(NoHandlerFoundException.class)
  public Result<String> handleNotFound(NoHandlerFoundException e) {
    log.warn("路径未找到: {}", e.getRequestURL());
    return Result.error("接口路径不存在");
  }

  // 默认兜底异常
  @ExceptionHandler(Exception.class)
  public Result<String> handleGlobal(Exception e) {
    log.error("运行时异常: {}", e.getMessage(), e);
    return Result.error(e.getMessage());
  }


}