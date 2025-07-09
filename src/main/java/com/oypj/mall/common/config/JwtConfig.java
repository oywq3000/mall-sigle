package com.oypj.mall.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtConfig {
    private String secret;//JWT加解密使用的密钥
    private Long expiration;//JWT的超期限时间

    private String tokenHeader;//JWT存储的请求头
    private String tokenHead; //JWT负载中拿到开头
}