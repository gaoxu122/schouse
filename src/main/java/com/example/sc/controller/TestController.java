package com.example.sc.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/iiii")
    public  void TestValue(){
        System.out.println(">>>>>>>>>>>>>>>>>");
    }
}
