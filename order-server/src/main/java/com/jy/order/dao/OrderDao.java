package com.jy.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.common.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单dao层接口
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 16:29
 */
@Mapper
public interface OrderDao extends BaseMapper<Order> {

    /**
     * 分页查询订单信息
     *
     * @param keyWord
     *        关键字
     * @param page
     *        分页信息
     * @return
     *        结果信息
     */
    List<Order> queryPageList(@Param("keyWord") String keyWord,@Param("page") Page<Order> page);
}
