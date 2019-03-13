package com.example.sc.biz.user;


import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.example.sc.baseResource.NailInterfaceAddress;
import com.example.sc.common.msg.ObjectRestResponse;
import com.example.sc.until.ding.constant.ResultRespose;
import com.example.sc.until.ding.msg.ErrorMsg;
import com.taobao.api.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019/3/12/
 * 测试用户详情信息的接口
 */
@Service
public class UserBiz {

    public ObjectRestResponse getUserMassage() {
        OapiUserGetuserinfoRequest request = new OapiUserGetuserinfoRequest();
        request.setHttpMethod("GET");
        OapiUserGetuserinfoResponse response = ResultRespose.resultRespose(NailInterfaceAddress.ACCESS_TOKEN_FOR_USER_ID, request);
        String userId = response.getUserid();
        return ObjectRestResponse.genJsonResultByOk(userId);
    }

    /**
     * 获得人员列表
     *
     * @return
     */
    public ObjectRestResponse getUserMassageList() {
        OapiUserGetResponse response = null;
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get");
        OapiUserGetRequest request = new OapiUserGetRequest();
        String userId = "manager8587";
        // userId="1415051140937204";
        request.setUserid(userId);
        request.setHttpMethod("GET");
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 获得部门下的人员列表
     *
     * @return
     */
    public ObjectRestResponse getDeptMemberUserMassage() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getDeptMember");
        OapiUserGetDeptMemberRequest req = new OapiUserGetDeptMemberRequest();
        req.setDeptId("104808476");
        req.setHttpMethod("GET");
        OapiUserGetDeptMemberResponse rsp = null;
        try {
            rsp = client.execute(req, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(rsp.getBody());
        return ObjectRestResponse.genJsonResultByOk(rsp);
    }

    /**
     * 获得部门下的用户列表，并分页显示
     *
     * @return
     */
    public ObjectRestResponse getSimpleUserMassage() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/simplelist");
        OapiUserSimplelistRequest request = new OapiUserSimplelistRequest();
        request.setDepartmentId(Long.valueOf(104808476));
        request.setOffset(0L);
        request.setSize(10L);
        request.setHttpMethod("GET");
        OapiUserSimplelistResponse response = null;

        try {
            response = client.execute(request, ResultRespose.getToken());
            System.out.println("body:" + response.getBody());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 获得人员信息并分页
     *
     * @return
     */
    public ObjectRestResponse getUserMassageListbyPage() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/listbypage");
        OapiUserListbypageRequest request = new OapiUserListbypageRequest();
        request.setDepartmentId(Long.valueOf(104808476));
        request.setOffset(0L);
        request.setSize(10L);
        request.setOrder("entry_desc");
        request.setHttpMethod("GET");
        OapiUserListbypageResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 获得管理员信息
     *
     * @return
     */
    public ObjectRestResponse getUserGetAdmin() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_admin");
        OapiUserGetAdminRequest request = new OapiUserGetAdminRequest();
        request.setHttpMethod("GET");
        OapiUserGetAdminResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 获取管理员通讯录权限范围
     *
     * @return
     */
    public ObjectRestResponse getUserGetAdminScope() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/user/get_admin_scope");
        OapiUserGetAdminScopeRequest req = new OapiUserGetAdminScopeRequest();
        req.setUserid("manager8587");
        OapiUserGetAdminScopeResponse response = null;
        try {
            response = client.execute(req, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 根据unionid获取userid
     *
     * @return
     */
    public ObjectRestResponse getUserGetUseridByUnionid() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/getUseridByUnionid");
        OapiUserGetUseridByUnionidRequest request = new OapiUserGetUseridByUnionidRequest();
        request.setUnionid("M9Ar4MVQA4vk4iPRwIJdTXAiEiE");
        request.setHttpMethod("GET");

        OapiUserGetUseridByUnionidResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 创建用户
     *
     * @return
     */
    public ObjectRestResponse CreateUser() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/create");
        OapiUserCreateRequest request = new OapiUserCreateRequest();
        request.setUserid("32145");
        request.setMobile("15566151257");
        request.setIsSenior(true);
        request.setName("喜羊羊");

        // 需要用字符串， "[59869009,60345027]" 这种格式
        List<Long> departments = new ArrayList<Long>();
        departments.add(Long.valueOf(104808476));
        // departments.add(200L);
        request.setDepartment(JSON.toJSONString(departments));

        OapiUserCreateResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        if ((ErrorMsg.REPEAT_USER_CODE.longValue()) == response.getErrcode()) {
            return ObjectRestResponse.genJsonResultByOk(response.getErrcode(), response.getErrmsg());
        }
        return ObjectRestResponse.genJsonResultByOk(response);

    }

    /**
     * 更新用户
     *
     * @return
     */
    public ObjectRestResponse UpdateUser() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/update");
        OapiUserUpdateRequest request = new OapiUserUpdateRequest();
        request.setUserid("32145");
        request.setName("狒羊羊");

        OapiUserUpdateResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 删除用户
     *
     * @return
     */
    public ObjectRestResponse DeleteUser() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/delete");
        OapiUserDeleteRequest request = new OapiUserDeleteRequest();
        request.setUserid("32145");
        request.setHttpMethod("GET");

        OapiUserDeleteResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return ObjectRestResponse.genJsonResultByOk(response);
    }
}
