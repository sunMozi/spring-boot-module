package com.mozisun.springboottlias.enums;

public enum Role {
  TEACHING_DIRECTOR(1, "班主任"),
  STUDENT_AFFAIRS_DIRECTOR(2, "讲师"),
  OTHER(3, "学工主管"),
  HEAD_TEACHER(4, "教研主管"),
  CONSULTANT(5, "咨询师"),
  LECTURER(6, "未知");

  private final int code;
  private final String name;

  Role(int code, String name) {
    this.code = code;
    this.name = name;
  }

  public static String getNameByCode(Integer code) {
    if (code == null) {
      return "未知角色";
    }
    for (Role role : values()) {
      if (role.code == code) {
        return role.name;
      }
    }
    return "未知角色";
  }
}