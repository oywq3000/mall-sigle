package com.oypj.mall.controller;

import com.oypj.mall.common.api.CommonResult;
import com.oypj.mall.service.UmsMemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author oy
 * @description 电话号码动态码管理Controller
 * @date 2025/07/08
 * @github https://github.com/oywq3000
 */
@RestController
@Tag(name = "UmsMemberController",description = "前台会员管理")
@RequestMapping("/sso")
@RequiredArgsConstructor
public class UmsMemberController {
    private final UmsMemberService umsMemberService;

    @Operation(summary = "获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone){
         return umsMemberService.generateAuthCode(telephone);
    }

    @Operation(summary = "判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public CommonResult updatePassword(@RequestParam String telephone, @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }
}
