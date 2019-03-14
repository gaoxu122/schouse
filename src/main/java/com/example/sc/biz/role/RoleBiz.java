package com.example.sc.biz.role;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRoleGetroleRequest;
import com.dingtalk.api.request.OapiRoleGetrolegroupRequest;
import com.dingtalk.api.request.OapiRoleListRequest;
import com.dingtalk.api.request.OapiRoleSimplelistRequest;
import com.dingtalk.api.response.OapiRoleGetroleResponse;
import com.dingtalk.api.response.OapiRoleGetrolegroupResponse;
import com.dingtalk.api.response.OapiRoleListResponse;
import com.dingtalk.api.response.OapiRoleSimplelistResponse;
import com.example.sc.common.msg.ObjectRestResponse;
import com.example.sc.until.ding.constant.ResultRespose;
import com.taobao.api.ApiException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RoleBiz {
    /**
     * 获取角色列表
     *
     * @return
     */
    public ObjectRestResponse getRoleList() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/role/list");
        OapiRoleListRequest request = new OapiRoleListRequest();
        // 分页偏移，默认值：0
        request.setOffset(0L);
        // 分页大小，默认值：20，最大值200
        request.setSize(10L);
        OapiRoleListResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error("错误信息为：" + e.getMessage());
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }


    /**
     * 获取角色下的员工列表
     *
     * @return
     */
    public ObjectRestResponse getRoleSimplelist() {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/role/simplelist");
        OapiRoleSimplelistRequest request = new OapiRoleSimplelistRequest();
        // 角色id可以从角色列表中获取
        request.setRoleId(419162326L);
        // 分页偏移，默认值：0
        request.setOffset(0L);
        // 分页大小，默认值：20，最大值200
        request.setSize(10L);

        OapiRoleSimplelistResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error("错误信息为：" + e.getMessage());
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 获取角色组
     *
     * @return
     */
    public ObjectRestResponse getRoleGroup() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/role/getrolegroup");
        OapiRoleGetrolegroupRequest request = new OapiRoleGetrolegroupRequest();
        // 设置角色组id 必须设置
        request.setGroupId(149507737L);
        OapiRoleGetrolegroupResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 获取角色详情
     *
     * @return
     */
    public ObjectRestResponse RoleGetrole() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/role/getrole");
        OapiRoleGetroleRequest req = new OapiRoleGetroleRequest();
        // 设置角色id 必须设置
        req.setRoleId(419162326L);
        OapiRoleGetroleResponse response = null;
        try {
            response = client.execute(req, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error("Class: " + this.getClass().getName() +
                    " method: " + Thread.currentThread().getStackTrace()[1].getMethodName() +
                    " line:" + Thread.currentThread().getStackTrace()[1].getLineNumber() +
                    " Error:" + e.getMessage());
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }


}
