package com.example.sc.common.msg;

import com.example.sc.common.constant.ReturnCode;
import com.example.sc.common.vo.TableData;


/**
 *ObjectRestResponse
 *
 *@description
 *
 *@author jianghx
 *@create 2018/8/23 16:16
 **/
public class ObjectRestResponse<T> extends BaseResponse {

    T data;
    boolean rel;


    /**
     * 返回成功数据
     * @return
     */
    public static ObjectRestResponse genJsonResultByOk() {
        ReturnCode codeOk = ReturnCode.CODE_OK;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        return objectRestResponse;
    }

    /**
     * 返回成功的数据
     *
     * @param data
     * @return
     */
    public static ObjectRestResponse genJsonResultByOk(Object data) {
        ReturnCode codeOk = ReturnCode.CODE_OK;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        objectRestResponse.setData(data);
        return objectRestResponse;
    }


    /**
     * 返回成功数据
     * @param status
     * @param msg
     * @return
     */
    public static ObjectRestResponse genJsonResultByOk(int status,String msg) {
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(status);
        objectRestResponse.setMessage(msg);
        return objectRestResponse;
    }

    /**
     * 返回成功数据
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static ObjectRestResponse genJsonResultByOk(int status,String msg,Object data) {
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(status);
        objectRestResponse.setMessage(msg);
        objectRestResponse.setData(data);
        return objectRestResponse;
    }


    /**
     * 返回列表类型数据
     * @param total
     * @param data
     * @return
     */
    public static ObjectRestResponse genTableResult(long total,Object data) {
        ReturnCode codeOk = ReturnCode.CODE_OK;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        TableData tableData = new  TableData(total, data);
        objectRestResponse.setData(new TableData(total, data));
        return objectRestResponse;
    }


    /**
     *
     * @param rel
     * @return
     */
    public static ObjectRestResponse genJsonResultOfRel(boolean rel) {
        ReturnCode codeOk = ReturnCode.CODE_OK;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        objectRestResponse.setRel(rel);
        return objectRestResponse;
    }

    /**
     *
     * @param rel
     * @param data
     * @return
     */
    public static ObjectRestResponse genJsonResultOfRelAndData(boolean rel,Object data) {
        ReturnCode codeOk = ReturnCode.CODE_OK;
        ObjectRestResponse objectRestResponse = new ObjectRestResponse();
        objectRestResponse.setStatus(codeOk.getCode());
        objectRestResponse.setMessage(codeOk.getMsg());
        objectRestResponse.setRel(rel);
        objectRestResponse.setData(data);
        return objectRestResponse;
    }

    public boolean isRel() {
        return rel;
    }

    public void setRel(boolean rel) {
        this.rel = rel;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



}