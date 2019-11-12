package com.example.comservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.team.service.TestService;
import org.springframework.stereotype.Component;


@Component
@Service(interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {
    @Override
    public String getH() {
        return "HelloWolder";
    }
}
