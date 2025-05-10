package com.spring_boot.springboothello.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author moZiA
 * @date 2025/5/4 11:19
 * @description
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Integer id;
  private String name;
  private Integer age;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}