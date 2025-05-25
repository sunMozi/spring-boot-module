package com.mozisun.springboottlias.model.vo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpLoginVO implements Serializable {

  private Integer id;

  private String userName;

  private String name;

  private String token;

}
