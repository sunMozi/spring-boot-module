package com.mozisun.springbootpayment.pojo;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PayRequest {

  /**
   * 商户订单号
   */
  private String orderId;

  /**
   * 支付金额（单位：元）
   */
  private BigDecimal amount;

  /**
   * 订单标题
   */
  private String subject;

  /**
   * 订单描述
   */
  private String description;

  /**
   * 支付渠道（如 ALIPAY、WECHAT）
   */
  private String payType;
}
