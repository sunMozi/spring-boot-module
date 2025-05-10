package com.spring_boot.springboothello.contriller;


import com.spring_boot.springboothello.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/5/4 11:05
 * @description 名称一致性原则 , 对象属性一致性原则
 */
@RestController
public class SpringBootRequestController {

  private static final Logger logger = LoggerFactory.getLogger(SpringBootRequestController.class);

  @RequestMapping("request1")
  public String request1(@RequestParam(name = "name" ) String name, Integer age) {
    logger.info("name:{}, age:{}", name, age);
    return "SUCCESS";
  }

  @RequestMapping("request2")
  public String request2(@RequestParam User user) {
    logger.info("user:{}", user);
    return "SUCCESS";
  }
}