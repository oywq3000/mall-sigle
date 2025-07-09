package com.oypj.mall.common.api;

/**
 * @author oy
 * @description API返回码接口
 * @date 2025/07/08
 * @github https://github.com/oywq3000
 */
public enum ResultCode implements IErrorCode{
    SUCCESS(200,"操作成功"),
    FAILED(500,"操作失败"),
    VALIDATE_FAILED(404,"参数校验失败"),
    UNAUTHORIZED(401,"暂未登入或token已经经过"),
    FORBIDDEN(403,"没有相关权限");
    private long code;
    private String message;
    ResultCode(long code,String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public long getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
