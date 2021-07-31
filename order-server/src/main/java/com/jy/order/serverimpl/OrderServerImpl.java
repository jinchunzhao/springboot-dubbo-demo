package com.jy.order.serverimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.api.order.OrderServer;
import com.jy.common.pojo.Order;
import com.jy.order.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 订单服务接口实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 16:30
 */
@Slf4j
@Component
@Service(version = "1.0.0",interfaceClass = OrderServer.class,timeout = 6000)
public class OrderServerImpl extends ServiceImpl<OrderDao, Order> implements OrderServer {
}
