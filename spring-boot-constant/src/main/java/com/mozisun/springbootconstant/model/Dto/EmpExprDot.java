package com.mozisun.springbootconstant.model.Dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/14 17:09
 * @description
 */
@Getter
@Setter
public class EmpExprDot {

  private Integer empId; //员工ID
  @NotEmpty
  private LocalDate begin; //开始时间
  @NotNull
  private LocalDate end; //结束时间
  @NotEmpty
  private String company; //公司名称
  @NotEmpty
  private String job; //职位
}