package com.example.managerweb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.team.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference(interfaceClass = TestService.class)
    private TestService testService;

    @RequestMapping("/getHW")
    public String getHW(){
        return testService.getH();
    }

}
