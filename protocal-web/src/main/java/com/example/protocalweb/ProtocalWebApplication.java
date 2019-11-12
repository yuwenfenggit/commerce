package com.example.protocalweb;


import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableDubboConfiguration
@SpringBootApplication
public class ProtocalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProtocalWebApplication.class, args);
    }

}
