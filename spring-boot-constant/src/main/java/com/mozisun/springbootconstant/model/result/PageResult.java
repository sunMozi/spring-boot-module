package com.mozisun.springbootconstant.model.result;


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/14 11:04
 * @description
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResult<T> {

  private Long total;
  private List<T> rows;


}