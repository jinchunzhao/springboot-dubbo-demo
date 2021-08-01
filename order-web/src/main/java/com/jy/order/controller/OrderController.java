package com.jy.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.api.order.OrderServer;
import com.jy.common.base.BaseController;
import com.jy.common.page.PageParam;
import com.jy.common.pojo.Order;
import com.jy.common.web.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单接口
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 17:52
 */
@RestController
@RequestMapping("/order")
@Api(value = "订单管理", tags = {"订单管理相关接口"})
public class OrderController extends BaseController {

    @Reference(check = false,version = "1.0.0",url = "dubbo://127.0.0.1:20882",lazy = true)
    private OrderServer orderServer;


    @ResponseBody
    @ApiOperation(value = "订单列表查询", notes = "订单列表分页查询")
    @PostMapping("/list")
    public ResultBean list(@Validated @RequestBody PageParam<String> pageParam){
        Page<Order> page = orderServer.queryPageList(pageParam.getParam(),buildPage(pageParam));
        return ResultBean.success(page);
    }

}
