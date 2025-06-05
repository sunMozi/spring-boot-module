package com.mozisun.springboottlias.model.entiry;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

  @NotEmpty(message = "部门名称不能为空")
  private String name;
  private LocalDateTime createTime;
  private LocalDateTime updateTime;


}