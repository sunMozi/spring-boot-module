package com.mozisun.springbootpayment.config.pay;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "pay.alipay")
public class AlipayProperties {
    private String appId;
    private String privateKey;
    private String publicKey;
    private String gatewayUrl;
    private String notifyUrl;
}
