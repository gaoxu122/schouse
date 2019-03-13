package com.example.sc.biz;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiServiceGetCorpTokenResponse;
import com.example.sc.common.msg.ObjectRestResponse;
import com.example.sc.until.ding.BasicMethod;
import com.example.sc.until.ding.ITAccessToken;
import com.example.sc.baseResource.ITStaticConstant;
import com.example.sc.baseResource.NailInterfaceAddress;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;

/**
 *
 *
 */
@Service
public class AccessTokenBiz  {


    /**
     *
     * @return
     */
    public JSON getAccessToken(){

        String suiteTicket="weqweqwe";
        String suiteSecretEncode = BasicMethod.urlEncode(ITStaticConstant.DING_SUITE_SECRET,ITStaticConstant.ENCODING_RULE);
        OapiServiceGetCorpTokenResponse
        oapiServiceGetCorpTokenResponse=ITAccessToken.getAccessToken(NailInterfaceAddress.ACCESS_TOKEN_ADDRESS,
                ITStaticConstant.DING_CORP_ID,ITStaticConstant.DING_SUITE_KEY,
                suiteSecretEncode,suiteTicket);
        if (oapiServiceGetCorpTokenResponse==null){
            return null;
        }
        return null;
    }

    public JSON getToken(){

        JSONObject result = null;

        DefaultDingTalkClient client = new DefaultDingTalkClient(NailInterfaceAddress.TOKEN_ADDRESS);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(ITStaticConstant.APP_KEY);
        request.setAppsecret(ITStaticConstant.APP_SECRET);
        request.setHttpMethod("GET");

        try {
            OapiGettokenResponse response = client.execute(request);
            result = (JSONObject) JSONObject.toJSON(response); // 将java对象转换为json对象

            System.out.println("token请求结果==> " + result.toString());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return result;
    }



}
