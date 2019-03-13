package com.example.sc.baseResource;

public class NailInterfaceAddress {
    /**
     * token生成接口
     */
    public static String ACCESS_TOKEN_ADDRESS = "https://oapi.dingtalk.com/service/get_corp_token";
    /**
     * token生成接口
     */
    public static String TOKEN_ADDRESS = "https://oapi.dingtalk.com/gettoken";
    /**
     * 通过token获得userId
     */
    public static String ACCESS_TOKEN_FOR_USER_ID = " https://oapi.dingtalk.com/user/getuserinfo";
    /**
     * 获得用户信息列表
     */
    public static String USER_ID_LIST = " https://oapi.dingtalk.com/user/get";
    /**
     *  获得部门下的人员列表
     */
    public static String DEPT_MEMBER_USER_ID_LIST = "https://oapi.dingtalk.com/user/getDeptMember";
}
