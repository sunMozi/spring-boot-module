package com.mozisun.springboottlias.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/5/23 10:14
 * @description
 */
@Aspect
@Component
@Slf4j
public class RecordTimeAspect {


  //  切点
  @Pointcut(value = "execution(* com.mozisun.springboottlias.server.impl.DeptServerImpl.*(..))")
  public void pc() {
  }

  @Around("pc()")
  public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object obj = joinPoint.proceed();
    long end = System.currentTimeMillis();

    log.info("{} 方法执行开始 , 方法执行耗时 : {}ms",
             joinPoint.getSignature().getName(),
             end - start);
    return obj;
  }

}