package com.example.sc.controller;

import com.example.sc.biz.department.DepartmentBiz;
import com.example.sc.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentBiz departmentBiz;

    @RequestMapping(value = "/department",method = RequestMethod.GET)
    public ObjectRestResponse getDeoarmentMsg(){
        return departmentBiz.UserGetOrgUserCount();
    }
}
