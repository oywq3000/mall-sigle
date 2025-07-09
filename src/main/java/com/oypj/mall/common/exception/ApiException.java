package com.oypj.mall.common.exception;


import com.oypj.mall.common.api.IErrorCode;

/**
 * @author oy
 * @description 自定义API异常
 * @date 2025/07/08
 * @github https://github.com/oywq3000
 */
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message){
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
