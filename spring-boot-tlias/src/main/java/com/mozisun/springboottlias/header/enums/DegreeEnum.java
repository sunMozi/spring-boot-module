package com.mozisun.springboottlias.header.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DegreeEnum {
  JUNIOR_HIGH("初中", 1),
  SENIOR_HIGH("高中", 2),
  COLLEGE("大专", 3),
  BACHELOR("本科", 4),
  MASTER("硕士", 5),
  DOCTOR("博士", 6);

  private final String name;
  private final int code;

}
