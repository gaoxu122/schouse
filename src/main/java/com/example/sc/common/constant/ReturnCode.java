package com.example.sc.common.constant;

/**
 *PBReturnCode
 *
 *返回错误码，对外接口一定要设置错误码 错误码按照顺序递增，不要重复
 *
 *@author jianghx
 *@create 2018/8/20 10:08
 **/
public enum ReturnCode {

    /**
     * 正常响应状态码
     */
    CODE_OK(200, "成功"),


    FORBIDDEN_ERROR(403,"拒绝访问"),


    TOKEN_FORBIDDEN_CODE(40100,"禁止访问"),
    TOKEN_ERROR_CODE(40101,"token异常"),
    TOKEN_FORBIDDEN_NULL_CODE(40102,"禁止访问:token不存"),
    TOKEN_FORBIDDEN_EXPIRE_CODE(40103,"禁止访问:token过期"),
    TOKEN_FORBIDDEN_SIGNATURE_CODE(40104,"禁止访问:签名错误"),
    CLIENT_TOKEN_ERROR_CODE(40201,"客户端token异常"),
    LOGIN_ERROR(40000,"login error"),
    USER_INVALID_ERROR_CODE(40301,"用戶无效"),




    SYS_ERROR(500, "系统繁忙");




    private Integer code;

    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "code:" + code + ", msg" + msg;
    }
}
