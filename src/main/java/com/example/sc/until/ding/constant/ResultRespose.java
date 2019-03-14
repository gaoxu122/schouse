package com.example.sc.until.ding.constant;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserGetuserinfoRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserGetuserinfoResponse;
import com.example.sc.baseResource.ITStaticConstant;
import com.example.sc.baseResource.NailInterfaceAddress;
import com.example.sc.until.ding.ITAccessToken;
import com.taobao.api.ApiException;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class ResultRespose {


    public static OapiUserGetuserinfoResponse resultRespose(String path, OapiUserGetuserinfoRequest request) {
        OapiUserGetuserinfoResponse response = null;
        DingTalkClient client = new DefaultDingTalkClient(path);
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error("ApiException"+e.getMessage());
        }
        return response;
    }

    /**
     * 获得token
     * @return
     */
    public static String getToken() {
        String result = null;
        DefaultDingTalkClient client = new DefaultDingTalkClient(NailInterfaceAddress.TOKEN_ADDRESS);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(ITStaticConstant.APP_KEY);
        request.setAppsecret(ITStaticConstant.APP_SECRET);
        request.setHttpMethod("GET");
        try {
            OapiGettokenResponse response = client.execute(request);
            result = response.getAccessToken();
            log.info("token请求结果==========>"+result);
        } catch (ApiException e) {
            log.error("抛出的异常为:"+e.getMessage());
        }
        return result;
    }
}
