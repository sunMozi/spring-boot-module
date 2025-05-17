package com.mozisun.springboottlias.model.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/14 11:04
 * @description
 */
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResult<T> {

  private Long total;
  private List<T> rows;



}