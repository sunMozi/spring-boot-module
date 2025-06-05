package com.mozisun.springbootconstant.model.Dto;


import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/17 18:08
 * @description
 */
@Getter
@Setter
public class StudentQuery extends PageQuery {

  private String name;
  private Integer degree;
  private Long clazzId;

}