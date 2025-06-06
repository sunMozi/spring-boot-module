package com.mozisun.springbootpayment.server;


import com.mozisun.springbootpayment.pojo.PayRequest;

/**
 * @author moZiA
 * @date 2025/6/6 16:46
 * @description
 */
public interface PayService {
  /**
   * 提交支付请求
   */
  String submitOrder(PayRequest request);

  /**
   * 异步通知回调
   */
  String handleNotify(String payload);
}
