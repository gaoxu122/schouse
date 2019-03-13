package com.example.sc.controller;


import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DingTalkClient;
import com.example.sc.biz.AccessTokenBiz;
import com.example.sc.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    AccessTokenBiz accessTokenBiz;

    @RequestMapping(value = "/iiii" ,method = RequestMethod.GET)
    public ObjectRestResponse TestValue(){

     return ObjectRestResponse.genJsonResultByOk(accessTokenBiz.getToken());
    }
}
