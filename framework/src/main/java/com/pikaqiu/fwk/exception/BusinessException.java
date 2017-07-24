package com.pikaqiu.fwk.exception;

import com.pikaqiu.fwk.common.Error;

/**
 * 业务异常类
 */
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException() {}

    /**
     * 构造异常类
     */
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 根据枚举类构造异常结果
     */
    public BusinessException(Error.ErrorStatus status) {
        super(status.getMsg());
        this.code = status.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
