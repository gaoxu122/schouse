package com.example.sc.common.msg;

import com.example.sc.common.constant.ReturnCode;

/**
 * BaseResponse
 * <p>
 * 公共响应类
 *
 * @author jianghx
 * @create 2018/8/21 15:31
 **/
public class BaseResponse {
    private int status = ReturnCode.CODE_OK.getCode();
    private Long LongStatus = ReturnCode.USER_ERROR.getLongCode();
    private String message;

    public BaseResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }


    public BaseResponse() {
        this.status = ReturnCode.CODE_OK.getCode();
        this.message = ReturnCode.CODE_OK.getMsg();

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getLongStatus() {
        return LongStatus;
    }

    public void setLongStatus(Long longStatus) {
        LongStatus = longStatus;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
