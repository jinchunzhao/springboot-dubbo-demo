package com.jy.order;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 订单对外接口
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 18:58
 */
//@EnableDubboConfiguration
@SpringBootApplication
public class OrderWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderWebApplication.class, args);
    }

}
