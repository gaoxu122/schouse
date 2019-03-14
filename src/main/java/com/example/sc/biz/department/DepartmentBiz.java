package com.example.sc.biz.department;


import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.example.sc.common.msg.ObjectRestResponse;
import com.example.sc.until.ding.constant.ResultRespose;
import com.taobao.api.ApiException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;


@Service
@Log4j2
public class DepartmentBiz {
    /**
     * 获取子部门ID列表
     *
     * @return
     */
    public ObjectRestResponse DepartmentListIds() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list_ids");
        OapiDepartmentListIdsRequest request = new OapiDepartmentListIdsRequest();
        // 父部门id。根部门的话传1
        String id = "1";
        request.setId(id);
        request.setHttpMethod("GET");
        OapiDepartmentListIdsResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return ObjectRestResponse.genJsonResultByOk(response);

    }

    /**
     * 获取部门列表
     *
     * @return
     */
    public ObjectRestResponse DepartmentList() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list");
        OapiDepartmentListRequest request = new OapiDepartmentListRequest();
        request.setId("1");
        request.setHttpMethod("GET");
        OapiDepartmentListResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 获取部门详情
     *
     * @return
     */
    public ObjectRestResponse GetDepartment() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/get");
        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
        request.setId("2");
        request.setHttpMethod("GET");
        OapiDepartmentGetResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 查询部门的所有上级父部门路径
     *
     * @return
     */
    public ObjectRestResponse DepartmentListParentDeptsByDept() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list_parent_depts_by_dept");
        OapiDepartmentListParentDeptsByDeptRequest request = new OapiDepartmentListParentDeptsByDeptRequest();
        request.setId("105688277");
        request.setHttpMethod("GET");
        OapiDepartmentListParentDeptsByDeptResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }

    /**
     * 查询指定用户的所有上级父部门路径
     *
     * @return
     */
    public ObjectRestResponse DepartmentListParentDepts() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/department/list_parent_depts");
        OapiDepartmentListParentDeptsRequest request = new OapiDepartmentListParentDeptsRequest();
        request.setUserId("2245483800-2056871264");
        request.setHttpMethod("GET");
        OapiDepartmentListParentDeptsResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }
    /**
     * 获取企业员工人数
     * @return
     */
    public ObjectRestResponse UserGetOrgUserCount() {

        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/user/get_org_user_count");
        OapiUserGetOrgUserCountRequest request = new OapiUserGetOrgUserCountRequest();
        request.setOnlyActive(0L);
        request.setHttpMethod("GET");
        OapiUserGetOrgUserCountResponse response = null;
        try {
            response = client.execute(request, ResultRespose.getToken());
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return ObjectRestResponse.genJsonResultByOk(response);
    }
}
