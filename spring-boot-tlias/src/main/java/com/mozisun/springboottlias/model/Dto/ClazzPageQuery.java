package com.mozisun.springboottlias.model.Dto;


import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/14 15:50
 * @description
 */
@Setter
@Getter
public class ClazzPageQuery extends PageQuery {

  private String name;
  private Integer gender;
  private LocalDate begin;
  private LocalDate end;

}