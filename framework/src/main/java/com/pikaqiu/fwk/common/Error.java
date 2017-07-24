package com.pikaqiu.fwk.common;

/**
 * Created by user on 2016/9/26.
 */
public abstract class Error {

    public interface ErrorStatus {
        int getCode();

        String getMsg();
    }

    public enum TestException implements ErrorStatus {
        TEST_EXP(9001, "测试异常!"),
        TEST_OTHER(9002, "其他异常!");
        private int code;
        private String msg;

        TestException(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }

    public enum LoginException implements ErrorStatus {
        ACCOUNT_LOCKED(1001, "账户被锁定!"),
        ACCOUNT_DISABLED(1002, "账户不可用!"),
        ACCOUNT_EXPIRED(1003, "账户已过期!"),
        ACCOUNT_PASSWORD_FAIL(1004, "账号或密码错误!"),
        LOGIN_FAIL(1005, "未知登录错误"),
        ACCOUNT_EXCEPTION(1006, "账号异常!"),
        LOGIN_EXPIRED(1007,"登录超时或失效,请重新登录!");
        private int code;
        private String msg;

        LoginException(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }


    public enum BaseError implements ErrorStatus {
        NETWORK_SERVER_ERROR(1000, "网络异常/请求超时,请重试!"),
        PARAMS_REQUEST_ERROR(2000, "请求参数异常,请检查请求参数!"),
        SYSTEM_UNKNOWN_ERROR(3000, "系统异常,请稍后重试!"),
        EMPTY_ACCESS_TOKEN(4000, "access token为空"),
        INVALID_ACCESS_TOKEN(5000, "无效的access token!"),
        PARAM_SIGN_NOT_VALID(6000, "参数签名不通过!"),
        INVALID_OPERATION(7000, "不合法的操作请求!"),
        AUTHENTICATION_FAILURE(8000, "账号信息认证失败"),
        DATE_FORMAT_INVALID(9000, "时间/日期格式不对!"),
        REPEAT_REQUEST_ERROR(10000, "请勿重复请求");
        private int code;
        private String msg;

        BaseError(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
