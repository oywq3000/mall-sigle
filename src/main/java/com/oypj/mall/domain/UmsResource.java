package com.oypj.mall.domain;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * @author oy
 * @description 后台资源表
 * @date 2025/07/08
 * @github https://github.com/oywq3000
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class UmsResource {
    private Long id;
    private Date createTime;
    private String name;
    private String url;
    private String description;
    private Long categoryId;
}
