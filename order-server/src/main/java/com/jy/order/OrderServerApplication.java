package com.jy.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

/**
 * 订单服务启动类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 16:34
 */
@EnableDubboConfiguration
@SpringBootApplication
@ComponentScan(value = {"com.jy.**"})
public class OrderServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }

}
