package com.oypj.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.oypj.mall.common.exception.ApiException;
import com.oypj.mall.common.utils.JwtTokenUtil;
import com.oypj.mall.domain.AdminUserDetails;
import com.oypj.mall.domain.UmsResource;
import com.oypj.mall.service.UmsAdminService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author oy
 * @description 后台用户管理Service实现类
 * @date 2025/07/08
 * @github https://github.com/oywq3000
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UmsAdminServiceImpl implements UmsAdminService {

    //存访用户默认信息
    private List<AdminUserDetails> adminUserDetailsList = new ArrayList<>();

    //存放默认资源信息
    private List<UmsResource> resourceList = new ArrayList<>();

    private final JwtTokenUtil jwtTokenUtil;

    @PostConstruct
    private void init(){
        adminUserDetailsList.add(AdminUserDetails.builder()
                .username("admin")
                .password(BCrypt.hashpw("123456"))
                .authorityList(CollUtil.toList("brand:create","brand:update","brand:delete","brand:list","brand:listAll"))
                .build());
        adminUserDetailsList.add(AdminUserDetails.builder()
                .username("macro")
                .password(BCrypt.hashpw("123456"))
                .authorityList(CollUtil.toList("brand:listAll"))
                .build());

        resourceList.add(UmsResource.builder()
                .id(1L)
                .name("brand:create")
                .url("/brand/create")
                .build());
        resourceList.add(UmsResource.builder()
                .id(2L)
                .name("brand:update")
                .url("/brand/update/**")
                .build());
        resourceList.add(UmsResource.builder()
                .id(3L)
                .name("brand:delete")
                .url("/brand/delete/**")
                .build());
        resourceList.add(UmsResource.builder()
                .id(3L)
                .name("brand:delete")
                .url("/brand/delete/**")
                .build());
        resourceList.add(UmsResource.builder()
                .id(5L)
                .name("brand:listAll")
                .url("/brand/listAll")
                .build());
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        AdminUserDetails userDetails = getAdminByUsername(username);
        if(userDetails==null){
            return token;
        }
        if(!BCrypt.checkpw(password,userDetails.getPassword())){
            throw new ApiException("密码不正确");
        }
        //todo 对接sa-token
        token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }
    private AdminUserDetails getAdminByUsername(String username) {
        List<AdminUserDetails> findList = adminUserDetailsList.stream().filter(
                item->item.getUsername().equals(username)
        ).collect(Collectors.toList());

        if (CollUtil.isNotEmpty(findList)){
            return findList.get(0);
        }
        return null;
    }

    @Override
    public List<UmsResource> getResourceList() {
        return resourceList;
    }
}
