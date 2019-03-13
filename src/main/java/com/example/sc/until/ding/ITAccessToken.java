package com.example.sc.until.ding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiServiceGetCorpTokenRequest;
import com.dingtalk.api.response.OapiServiceGetCorpTokenResponse;
import com.example.sc.baseResource.ITStaticConstant;
import com.example.sc.until.ding.BasicMethod;

import java.net.URLEncoder;

/**
 * @author gaoxu
 * @date 2019/3/11
 */


public class ITAccessToken {
    /**
     *  获得企业的token
     * @param path           接口的路径
     * @param corpid         企业的corpid
     * @param accessKey      ISV应用的suiteKey
     * @param suiteSecret    签名密钥
     * @param suiteTicket    钉钉给套件推送的ticket，测试应用可以随意填写
     * @param timestamp      当前时间戳，单位是毫秒
     * @param signature      以timestamp+"\n"+suiteTicket为签名字符串，
     *                       suiteSecret为签名密钥，使用算法HmacSHA256计算的签名值。
     *                       注意：计算出签名以后，需要进行urlencode，才能把签名参数拼接到url中。
     *
     * @return
     */
    public static OapiServiceGetCorpTokenResponse getAccessToken(String path, String corpid,
                                                                 String accessKey, String suiteSecret,
                                                                  String suiteTicket) {

        // 当前时间的时间戳
        String timestamp=String.valueOf(System.currentTimeMillis());
        System.out.println(timestamp);
        DefaultDingTalkClient client = new DefaultDingTalkClient(path);
        OapiServiceGetCorpTokenRequest request = new OapiServiceGetCorpTokenRequest();
        request.setHttpMethod("POST");
        request.setAuthCorpid(corpid);
        try {
            String encoded = URLEncoder.encode(BasicMethod.resultSignature(timestamp, suiteTicket, suiteSecret), ITStaticConstant.ENCODING_RULE);
            OapiServiceGetCorpTokenResponse response = client.execute(request, accessKey, suiteSecret, suiteTicket);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }


}
