package com.jy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 用户服务启动类
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 16:42
 */
@EnableDubboConfiguration
@SpringBootApplication
@ComponentScan(value = {"com.jy.**"})
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }

}
