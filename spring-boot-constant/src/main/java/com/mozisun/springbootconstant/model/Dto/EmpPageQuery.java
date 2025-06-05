package com.mozisun.springbootconstant.model.Dto;


import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/14 11:12
 * @description
 */
@Setter
@Getter
public class EmpPageQuery extends PageQuery {

  private String name;
  private Integer gender;
  private LocalDate begin;
  private LocalDate end;


}