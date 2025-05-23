package com.mozisun.springboottlias.header.exception;

import com.mozisun.springboottlias.header.enums.Code;

public class BizException extends BaseException {

  public BizException(String message) {
    super(message);
  }

  public BizException(Code code) {
    super(code.getMessage());
  }
}
