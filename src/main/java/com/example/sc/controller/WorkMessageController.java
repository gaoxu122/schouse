package com.example.sc.controller;


import com.example.sc.biz.work.WorkMessageBiz;
import com.example.sc.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkMessageController {


    @Autowired
    WorkMessageBiz workMessageBiz;

    @RequestMapping(value = "/work", method = RequestMethod.GET)
    public ObjectRestResponse getWorkMessage() {

        return workMessageBiz.sendMessageCorpconversation();

    }
}
