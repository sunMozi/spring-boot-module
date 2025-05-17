package com.mozisun.springboottlias.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/5/16 15:53
 * @description
 */

@Component
@Getter
public class AppConfig {

  @Value("${spring.application.image_dir}")
  public String image_dir;



}