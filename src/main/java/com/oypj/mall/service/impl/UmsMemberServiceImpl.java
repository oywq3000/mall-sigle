package com.oypj.mall.service.impl;

import cn.hutool.core.util.StrUtil;
import com.oypj.mall.common.api.CommonResult;
import com.oypj.mall.common.config.RedisKeyConfig;
import com.oypj.mall.service.RedisService;
import com.oypj.mall.service.UmsMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class UmsMemberServiceImpl implements UmsMemberService {

    private final RedisService redisService;
    private final RedisKeyConfig redisKeyConfig;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis中
        redisService.set(redisKeyConfig.getPrefix().getAuthCode()+telephone,sb.toString());
        redisService.expire(redisKeyConfig.getPrefix().getAuthCode()+telephone,redisKeyConfig.getExpire().getAuthCode());

        return CommonResult.success(sb.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(StrUtil.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = (String) redisService.get(redisKeyConfig.getPrefix().getAuthCode() + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
