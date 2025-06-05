package com.mozisun.springbootconstant.model.entiry;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author moZiA
 * @date 2025/5/17 9:10
 * @description
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpLog {

  private Integer id; //ID
  private LocalDateTime operateTime; //操作时间
  private String info; //详细信息
}
