package com.mozisun.springboottlias.model.vo;


import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/16 16:30
 * @description
 */
@Setter
@Getter
public class ExprVo {

  private Integer id;
  private LocalDate begin;
  private LocalDate end;
  private String company;
  private String job;
  private Integer empId;

}