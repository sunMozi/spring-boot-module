package com.mozisun.springbootconstant.model.entiry;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author moZiA
 * @date 2025/5/11 10:46
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

  private Integer id;
  private String name;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;


}