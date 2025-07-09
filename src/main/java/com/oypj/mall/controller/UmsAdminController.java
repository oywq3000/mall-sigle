package com.oypj.mall.controller;


import com.oypj.mall.common.api.CommonResult;
import com.oypj.mall.common.config.JwtConfig;
import com.oypj.mall.domain.UmsResource;
import com.oypj.mall.service.UmsAdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author oy
 * @description 后台用户管理
 * @date 2025/07/07
 * @github https://github.com/oywq3000
 */

@RestController
@Tag(name = "UmsAdminController",description = "后台用户管理")
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UmsAdminController {
    private final UmsAdminService umsAdminService;
    private final JwtConfig jwtConfig;

    @Operation(summary = "登录以返回token")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password){
        String token =umsAdminService.login(username,password);
        if(token==null){
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",jwtConfig.getTokenHead());
        return CommonResult.success(tokenMap);
    }

    @Operation(summary = "获取所有资源列表")
    @PostMapping(value = "/resourceList")
    public CommonResult<List<UmsResource>> resourceList(){
        List<UmsResource> resourceList = umsAdminService.getResourceList();
        return CommonResult.success(resourceList);
    }

}
