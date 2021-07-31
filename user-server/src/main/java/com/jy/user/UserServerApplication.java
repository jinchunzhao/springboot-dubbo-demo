package com.jy.user;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户服务启动类
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 16:35
 */
@EnableDubboConfiguration
@SpringBootApplication
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }

}
