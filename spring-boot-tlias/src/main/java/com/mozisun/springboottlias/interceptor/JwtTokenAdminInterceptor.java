package com.mozisun.springboottlias.interceptor;


import com.mozisun.springboottlias.context.BaseContext;
import com.mozisun.springboottlias.properties.JwtProperties;
import com.mozisun.springboottlias.utils.JwtUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author moZiA
 * @date 2025/5/14 13:56
 * @description
 */
@Component
@Slf4j
public class JwtTokenAdminInterceptor implements HandlerInterceptor {

  @Resource
  private JwtProperties jwtProperties;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    String token = request.getHeader(jwtProperties.getAdminTokenName());
    if (token == null){
      return true;
    }
    Map<String, Object> parseJWT = JwtUtils.parseJWT(jwtProperties.getAdminSecretKey(), token);
    Long l = Long.valueOf(parseJWT.get("emp_id").toString());
    BaseContext.setCurrentId(l);
    return true;
  }


  @Override
  public void afterCompletion(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler,
                              Exception ex) {
    BaseContext.removeCurrentId();
  }
}