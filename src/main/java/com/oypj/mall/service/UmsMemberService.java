package com.oypj.mall.service;

import com.oypj.mall.common.api.CommonResult;

public interface UmsMemberService {
    CommonResult generateAuthCode(String telephone);

    CommonResult verifyAuthCode(String telephone, String authCode);
}
