package com.webdemo.pojo;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moZiA
 * @date 2025/5/4 18:13
 * @description
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer id;
  private String username;
  private String password;
  private String name;
  private Integer age;
  private LocalDateTime updateTime;


}