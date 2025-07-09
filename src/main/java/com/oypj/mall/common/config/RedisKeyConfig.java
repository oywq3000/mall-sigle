package com.oypj.mall.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Redis 键配置属性类，用于绑定 YAML 配置文件中的 Redis 键相关配置
 */
@Component
@ConfigurationProperties(prefix = "redis.key")
@Data
public class RedisKeyConfig {

    /**
     * Redis 键前缀配置
     */
    private Prefix prefix;

    /**
     * Redis 键过期时间配置
     */
    private Expire expire;

    /**
     * 内部类，用于存储 Redis 键前缀相关配置
     */
    @Data
    public static class Prefix {
        /**
         * 验证码键前缀
         */
        private String authCode;
    }

    /**
     * 内部类，用于存储 Redis 键过期时间相关配置
     */
    @Data
    public static class Expire {
        /**
         * 验证码过期时间
         */
        private Long authCode;
    }
}