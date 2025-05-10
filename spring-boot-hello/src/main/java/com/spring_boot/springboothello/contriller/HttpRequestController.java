package com.spring_boot.springboothello.contriller;


import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/4 10:00
 * @description
 */
@RestController
public class HttpRequestController {

  private static final Logger logger = LoggerFactory.getLogger(HttpRequestController.class);

  @RequestMapping("/request")
  public String hello(HttpServletRequest request) {
    // 请求行
    String method = request.getMethod();
    logger.info("method : {} ", method);
    String requestURI = request.getRequestURI();
    logger.info("requestURI : {}", requestURI);
    String requestURL = request.getRequestURL().toString();
    logger.info("requestURL : {}", requestURL);
    String protocol = request.getProtocol();
    logger.info("protocol : {}", protocol);
    // 请求头
    String host = request.getHeader("host");
    logger.info("host : {}", host);

    return "SUCCESS";
  }


}