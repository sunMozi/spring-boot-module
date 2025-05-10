package com.spring_boot.springboothello.contriller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moZiA
 * @date 2025/4/30 11:28
 * @description
 */

@RestController
public class TestSpringBoot {

  @GetMapping("/hello")
  public String sendHello(String name) {
    return "hello" + name;
  }


}