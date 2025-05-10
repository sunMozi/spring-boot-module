package com.webdemo.pojo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moZiA
 * @date 2025/5/6 10:14
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

  private String name;
  private Integer weight;
  private Integer number;

}