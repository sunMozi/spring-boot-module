package com.mozisun.springboottlias.config;


import com.mozisun.springboottlias.interceptor.JwtTokenAdminInterceptor;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author moZiA
 * @date 2025/5/14 13:55
 * @description
 */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

  @Resource
  private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;


  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    log.info("开始注册自定义拦截器...");

    // 后台拦截器
    registry.addInterceptor(jwtTokenAdminInterceptor)
            .addPathPatterns("/login");
  }
}