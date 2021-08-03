package com.jy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 用户对外接口启动类
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-08-01 9:45
 */
@EnableDubboConfiguration
@SpringBootApplication
@ComponentScan(value = {"com.jy.**"})
public class UserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserWebApplication.class, args);
    }

}
