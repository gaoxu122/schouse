package com.example.sc.biz.work;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiChatCreateRequest;
import com.dingtalk.api.request.OapiChatSendRequest;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiMessageCorpconversationGetsendresultRequest;
import com.dingtalk.api.response.OapiChatCreateResponse;
import com.dingtalk.api.response.OapiChatSendResponse;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiMessageCorpconversationGetsendresultResponse;
import com.example.sc.common.msg.ObjectRestResponse;
import com.example.sc.until.ding.constant.ResultRespose;
import com.taobao.api.ApiException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Log4j2
public class WorkMessageBiz {

    /**
     * 发送工作消息
     *
     * @return
     */
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

        OapiMessageCorpconversationAsyncsendV2Response response = null;
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

    /**
     * 查询工作通知消息的发送结果
     *
     * @return
     */
    public ObjectRestResponse getSendResultMessageCorpconversation() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/message/corpconversation/getsendresult");
        OapiMessageCorpconversationGetsendresultRequest request = new OapiMessageCorpconversationGetsendresultRequest();
        // agent_id  :  微应用的agentid
        request.setAgentId(135717601L);
        // task_id	:	异步任务的id
        request.setTaskId(9326688016L);
        OapiMessageCorpconversationGetsendresultResponse response = null;
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

    /**
     * 发送群消息
     *
     * @return
     */
    public ObjectRestResponse getSendChat() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/chat/send");

        OapiChatSendRequest request = new OapiChatSendRequest();

        // 群会话的id，可以在调用创建群会话接口的返回结果里面获取，也可以通过dd.chooseChat获取
        request.setChatid("chate27b5326f06678a6386db113eed33dba");
        OapiChatSendRequest.Msg msg = new OapiChatSendRequest.Msg();
        msg.setMsgtype("text");
        OapiChatSendRequest.Text text = new OapiChatSendRequest.Text();
        text.setContent("大家好这个只是测试一下");
        msg.setText(text);

        request.setMsg(msg);
        OapiChatSendResponse response = null;
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

    /**
     * 创建会话
     *
     * @return
     */
    public ObjectRestResponse createChat() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/chat/create");
        OapiChatCreateRequest request = new OapiChatCreateRequest();
        request.setName("行路者");
        request.setOwner("manager8587");
        String[] userLists = new String[]{"1727413761653578", "2245483800-2056871264", "32145", "183434085420286867", "116017633029579", "1415051140937204"};
        request.setUseridlist(Arrays.asList(userLists));
        request.setShowHistoryType(1L);
        OapiChatCreateResponse response = null;
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
