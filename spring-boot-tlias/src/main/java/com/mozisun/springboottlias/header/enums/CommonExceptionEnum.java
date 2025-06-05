package com.mozisun.springboottlias.header.enums;


/**
 * @author moZiA
 * @date 2025/5/20 23:22
 * @description
 */
public enum CommonExceptionEnum implements Code {
  USER_NOT_EXIST(10001, "用户不存在"),
  USER_PASSWORD_ERROR(10002, "用户名或密码错误"),
  USER_NOT_LOGIN(10003, "用户未登录"),
  USER_NOT_ADMIN(10004, "用户无权限"),
  USER_NOT_EXIST_OR_PASSWORD_ERROR(10005, "用户不存在或密码错误"),
  USER_NOT_EXIST_OR_PASSWORD_ERROR_OR_NOT_ADMIN(10006, "用户不存在或密码错误或无权限"),
  DEM_ALREADY_EXISTS(10007, "部门已存在"),
  EMP_ALREADY_EXISTS(10007, "员工名称已存在"),
  EMP_USERNAME_ALREADY_EXISTS(10007, "员工昵称不能重复"),
  EMP_PHONE_ALREADY_EXISTS(10007, "员工手机号不能重复"),
  DEPT_HAS_EMP(10007, "部门下面有员工,不可删除"),
  CLASS_ID_INVALID(20001, "班级ID无效"),
  CLASS_NOT_EXIST(20002, "班级不存在"),
  CLASS_HAS_STUDENTS(20003, "班级下存在学生，不可删除"),
  CLAZZ_NOT_EXIST(20004, "班级不存在"),
  CLAZZ_NAME_ALREADY_EXISTS(20005, "班级名称已存在"),
  USERNAME_OR_PASSWORD_INVALID(10008, "用户名或密码不能为空或格式错误"),
  STUDENT_NO_EXISTS(30001, "学号已存在"),
  STUDENT_PHONE_EXISTS(30002, "手机号已存在"),
  STUDENT_ID_CARD_EXISTS(30003, "身份证号已存在"),
  STUDENT_PARAM_INVALID(30004, "学生信息参数不合法"),

  UNAUTHORIZED(401, "未授权访问，身份验证失败");

  private final Integer code;
  private final String message;


  CommonExceptionEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }


  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}