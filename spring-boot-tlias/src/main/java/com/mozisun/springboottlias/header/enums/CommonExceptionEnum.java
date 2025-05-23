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
  USER_NOT_EXIST_OR_PASSWORD_ERROR_OR_NOT_ADMIN(10006, "用户不存在或密码错误或无权限");


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