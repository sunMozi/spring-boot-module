package com.mozisun.springbootpayment.config.pay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pay.wechat")
public class WechatPayProperties {

  private String appId;
  private String mchId;
  private String mchKey;
  private String notifyUrl;
}
