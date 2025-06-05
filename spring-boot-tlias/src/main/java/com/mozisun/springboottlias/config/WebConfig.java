package com.mozisun.springboottlias.config;

import com.mozisun.springboottlias.interceptor.JwtTokenAdminInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Resource
  private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(jwtTokenAdminInterceptor)
            .addPathPatterns("/**")
            .excludePathPatterns(
                "/login",
                "/error",
                "/favicon.ico",
                "/swagger-ui.html",
                "/doc.html/**",
                "/swagger-ui/**",
                "/v3/api-docs/**"
            );
  }
}
