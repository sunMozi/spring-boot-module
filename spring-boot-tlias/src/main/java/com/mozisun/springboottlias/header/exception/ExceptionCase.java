package com.mozisun.springboottlias.header.exception;


import com.mozisun.springboottlias.header.enums.Code;

/**
 * @author moZiA
 * @date 2025/5/20 23:28
 * @description
 */
public class ExceptionCase {

  public static void cast(Code code) {
    throw new BizException(code);
  }
  
}