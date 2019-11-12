package com.example.comservice;


import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan(value = "com.team.mapper")
public class ComServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComServiceApplication.class, args);
    }

}
