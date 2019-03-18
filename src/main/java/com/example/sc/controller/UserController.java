package com.example.sc.controller;

import com.example.sc.biz.user.UserBiz;
import com.example.sc.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserBiz userBiz;

    /**
     * 获得人员的所有信息
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ObjectRestResponse userMassage() {
        return userBiz.getUserMassage();
    }

    /**
     * 创建用户
     *
     * @return
     */
    @RequestMapping(value = "/user_list", method = RequestMethod.GET)
    public ObjectRestResponse userMassageList() {
        return userBiz.CreateUser();
    }
}
