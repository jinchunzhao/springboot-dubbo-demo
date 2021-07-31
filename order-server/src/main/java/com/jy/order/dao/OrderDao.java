package com.jy.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.common.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单dao层接口
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 16:29
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {
}
