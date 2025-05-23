package com.mozisun.springboottlias.model.vo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/16 16:26
 * @description
 */
@Getter
@Setter
public class EmpExprVO {

  private Integer id;
  private String username;
  private String password;
  private String phone;
  private String name;
  private Integer gender;
  private String image;
  private Integer job;
  private Integer salary;
  private LocalDate entryDate;
  private Integer deptId;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;
  private List<ExprVo> exprList;


}