package com.example.sc.biz.work;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.example.sc.common.msg.ObjectRestResponse;
import com.example.sc.until.ding.constant.ResultRespose;
import com.taobao.api.ApiException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class WorkMessageBiz {

    public ObjectRestResponse sendMessageCorpconversation() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2");

        OapiMessageCorpconversationAsyncsendV2Request request = new OapiMessageCorpconversationAsyncsendV2Request();
        // 设置用户id的集合 格式为： 123,345
        request.setUseridList("01376814877479");
        // 企业内部应用是应用agentId，第三方企业应用是获取授权信息接口中返回的agentId
        request.setAgentId(153858650L);
        // 是否发送给企业全部用户 (ISV不能设置true)
        request.setToAllUser(false);

        // 设置文本信息的数据
        OapiMessageCorpconversationAsyncsendV2Request.Msg msg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        msg.setMsgtype("text");
        msg.setText(new OapiMessageCorpconversationAsyncsendV2Request.Text());
        msg.getText().setContent("test123");
        request.setMsg(msg);
        // 设置图片信息的数据
        msg.setMsgtype("image");
        msg.setImage(new OapiMessageCorpconversationAsyncsendV2Request.Image());
        msg.getImage().setMediaId("@lADOdvRYes0CbM0CbA");
        request.setMsg(msg);
        // 设置文件信息的数据
        msg.setMsgtype("file");
        msg.setFile(new OapiMessageCorpconversationAsyncsendV2Request.File());
        msg.getFile().setMediaId("@lADOdvRYes0CbM0CbA");
        request.setMsg(msg);
        // 设置链接
        msg.setMsgtype("link");
        msg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
        msg.getLink().setTitle("test");
        msg.getLink().setText("test");
        msg.getLink().setMessageUrl("test");
        msg.getLink().setPicUrl("test");
        request.setMsg(msg);
        // 降价
        msg.setMsgtype("markdown");
        msg.setMarkdown(new OapiMessageCorpconversationAsyncsendV2Request.Markdown());
        msg.getMarkdown().setText("##### text");
        msg.getMarkdown().setTitle("### Title");
        request.setMsg(msg);
        // 工作台信息
        msg.setOa(new OapiMessageCorpconversationAsyncsendV2Request.OA());
        msg.getOa().setHead(new OapiMessageCorpconversationAsyncsendV2Request.Head());
        msg.getOa().getHead().setText("head");
        msg.getOa().setBody(new OapiMessageCorpconversationAsyncsendV2Request.Body());
        msg.getOa().getBody().setContent("xxx");
        msg.setMsgtype("oa");
        request.setMsg(msg);
        // 歌曲信息
        msg.setActionCard(new OapiMessageCorpconversationAsyncsendV2Request.ActionCard());
        msg.getActionCard().setTitle("xxx123411111");
        msg.getActionCard().setMarkdown("### 测试123111");
        msg.getActionCard().setSingleTitle("测试测试");
        msg.getActionCard().setSingleUrl("https://www.baidu.com");
        msg.setMsgtype("action_card");
        request.setMsg(msg);

        OapiMessageCorpconversationAsyncsendV2Response response=null;
        try {
             response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error("Class: " + this.getClass().getName() +
                    " method: " + Thread.currentThread().getStackTrace()[1].getMethodName() +
                    " line:" + Thread.currentThread().getStackTrace()[1].getLineNumber() +
                    " Error:" + e.getMessage());
        }

        return ObjectRestResponse.genJsonResultByOk(response);
    }
}
