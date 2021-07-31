package com.jy.api.order;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.common.pojo.Order;
import com.jy.common.pojo.User;

/**
 * 订单 服务service接口
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:50
 */
public interface OrderServer extends IService<Order> {

    /**
     * 分页查询订单信息
     *
     * @param keyWord
     *        关键字
     * @param buildPage
     *        分页信息
     * @return
     *        结果信息
     */
    Page<Order> queryPageList(String keyWord, Page<Order> buildPage);
}
