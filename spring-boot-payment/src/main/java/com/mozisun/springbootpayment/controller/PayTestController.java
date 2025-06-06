package com.mozisun.springbootpayment.controller;

import com.mozisun.springbootpayment.config.pay.AlipayProperties;
import com.mozisun.springbootpayment.config.pay.WechatPayProperties;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PayTestController {

  @Resource
  private AlipayProperties alipay;

  @Resource
  private WechatPayProperties wechat;

  @GetMapping("/config")
  public Map<String, Object> getConfigs() {
    return Map.of("alipay", alipay, "wechat", wechat);
  }
}
