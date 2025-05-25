package com.mozisun.springboottlias.aop;


import com.mozisun.springboottlias.context.BaseContext;
import com.mozisun.springboottlias.mapper.OperateLogMapper;
import com.mozisun.springboottlias.model.entiry.OperateLog;
import com.mozisun.springboottlias.server.OperateLogServer;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/5/23 16:58
 * @description
 */
@Aspect
@Component
public class OperateLogAspect {


  @Resource
  private OperateLogServer operateLogServer;

  @Pointcut(value = "@annotation(com.mozisun.springboottlias.aop.anno.OperateLogAnno)")
  public void log() {
  }

  @Around("log()")
  public Object operateLog(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();
    long end = System.currentTimeMillis();
    OperateLog build = OperateLog.builder()
                                 .operateTime(LocalDateTime.now())
                                 .className(joinPoint.getTarget().getClass().getName())
                                 .methodName(joinPoint.getSignature().getName())
                                 .methodParams(Arrays.toString(joinPoint.getArgs()))
                                 .returnValue(proceed.toString())
                                 .costTime(end - start)
                                 .operateEmpId((int) (BaseContext.getCurrentId() != null
                                                          ? BaseContext.getCurrentId() : 1L))
                                 .build();

    operateLogServer.insertOperateLog(build);
    return proceed;
  }

}