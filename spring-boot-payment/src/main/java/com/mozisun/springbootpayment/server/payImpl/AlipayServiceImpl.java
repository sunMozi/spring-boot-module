package com.mozisun.springbootpayment.server.payImpl;

import com.mozisun.springbootpayment.pojo.PayRequest;
import com.mozisun.springbootpayment.server.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlipayServiceImpl implements PayService {

  @Override
  public String submitOrder(PayRequest request) {
    return "";
  }

  @Override
  public String handleNotify(String payload) {
    return "";
  }
}
