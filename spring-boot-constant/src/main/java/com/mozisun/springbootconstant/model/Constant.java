package com.mozisun.springbootconstant.model;


import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/25 15:16
 * @description
 */

@Setter
@Getter
public class Constant {

  private Long constantId;
  private String categoryCode;
  private String code;
  private String name;
  private Integer status;
  private Integer sortOrder;
}