package com.springbootmybatis.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author moZiA
 * @date 2025/5/8 15:24
 * @description 实体类 和数据库一 一 对应的类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {

  private Integer id;
  private String username;
  private String password;
  private String name;
  private Integer age;

}