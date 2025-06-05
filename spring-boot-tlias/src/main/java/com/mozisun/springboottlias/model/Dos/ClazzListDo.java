package com.mozisun.springboottlias.model.Dos;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author moZiA
 * @date 2025/5/14 15:56
 * @description
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClazzListDo {

  private Integer id;
  private String name;
  private String room;
  private LocalDate beginDate;
  private LocalDate endDate;
  private Integer masterId;
  private LocalDateTime createTime;

  private Integer subject;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private LocalDateTime updateTime;
  private String masterName;
  private String status;

}