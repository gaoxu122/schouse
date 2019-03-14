package com.example.sc.controller;

import com.example.sc.biz.role.RoleBiz;
import com.example.sc.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {


    @Autowired
    RoleBiz roleBiz;

    @RequestMapping(value = "/role_list",method = RequestMethod.GET)
    public ObjectRestResponse getRole(){
        return roleBiz.getRoleList();
    }

    /**
     * 获得该角色下的所有员工信息
     * @return
     */
    @RequestMapping(value = "/role_simple_list",method = RequestMethod.GET)
    public ObjectRestResponse getUserForRoleLists(){
        return roleBiz.RoleGetrole();
    }

}
