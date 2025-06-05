package com.mozisun.springboottlias.model.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author moZiA
 * @date 2025/5/11 10:50
 * @description
 * 后端统一返回的结果
 */

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

  private Integer code;
  private String message;
  private T data;


  private Result() {

  }

  /**
   * 成功的消息
   *
   * @param data 返回的数据
   * @return Result
   * @author MOZI
   */
  public static <T> Result<T> success(T data) {
    Result<T> result = new Result<>();
    result.setCode(1);
    result.setMessage("success");
    result.setData(data);
    return result;
  }

  /**
   * 成功的消息
   *
   * @return Result
   * @author MOZI
   */
  public static <T> Result<T> success() {
    Result<T> result = new Result<>();
    result.setCode(1);
    result.setMessage("success");
    return result;
  }


  /**
   * 相应失败的返回
   *
   * @param msg 返回的消息
   * @return Result
   * @author MOZI
   */
  public static Result<String> error(String msg) {
    Result<String> result = new Result<>();
    result.setCode(0);
    result.setMessage(msg);
    result.setData(null);
    return result;
  }

  public static Result<String> error(Integer code, String msg) {
    Result<String> result = new Result<>();
    result.setCode(code);
    result.setMessage(msg);
    result.setData(null);
    return result;
  }


}