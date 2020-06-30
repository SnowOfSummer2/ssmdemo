package com.study.ssmdemo.controller;

import com.study.ssmdemo.domain.Account;
import com.study.ssmdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(method = RequestMethod.GET)
    public Account test(){
        return testService.findOne();
    }
}
