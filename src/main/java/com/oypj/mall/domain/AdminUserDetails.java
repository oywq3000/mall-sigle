package com.oypj.mall.domain;


import jdk.dynalink.linker.LinkerServices;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.List;

/**
 * @author oy
 * @description SpringSecurity用户信息封装类
 * @date 2025/07/08
 * @github https://github.com/oywq3000
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class AdminUserDetails {
    private String username;
    private String password;
    private List<String> authorityList;

    public Collection<String> getAuthorities(){return authorityList;}

}
