package com.spring_boot.springboothello.pojo;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author moZiA
 * @date 2025/5/4 16:16
 * @description
 */
@AllArgsConstructor
@RequestMapping
@NoArgsConstructor
@Data
public class Student {

  private String name;
  private Integer age;
  private String address;
  private List<String> hoppyList;

}