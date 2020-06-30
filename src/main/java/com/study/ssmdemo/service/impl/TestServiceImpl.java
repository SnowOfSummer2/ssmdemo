package com.study.ssmdemo.service.impl;

import com.study.ssmdemo.domain.Account;
import com.study.ssmdemo.service.TestService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public void print() {
        System.out.println("测试spring环境搭建成功");
    }

    @Override
    public Account findOne() {
        Account ac=new Account();
        ac.setName("彭俊龙");
        ac.setId(1);
        return ac;
    }
}
