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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    /**
     * 订单列表查询
     *
     * @param pageParam
     *        分页信息
     * @return 结果信息
     */
    @ResponseBody
    @ApiOperation(value = "订单列表查询", notes = "订单列表分页查询")
    @PostMapping("/list")
    public ResultBean<Page<Order>> list(@Validated @RequestBody PageParam<String> pageParam){
        Page<Order> page = orderServer.queryPageList(pageParam.getParam(),buildPage(pageParam));
        return ResultBean.success(page);
    }


    /**
     * 创建订单
     *
     * @param order
     *        参数
     * @return
     *        结果信息
     * @throws Exception
     *         任何异常
     */
    @ResponseBody
    @ApiOperation(value = "创建订单", notes = "创建订单")
    @PostMapping("/createOrder")
    public ResultBean createOrder(@Validated @RequestBody Order order)throws Exception{
        return orderServer.createOrder(order);
    }


    /**
     * 根据订单id查询订单信息
     *
     * @param orderId
     *        订单id
     * @return
     *        结果信息
     */
    @ResponseBody
    @ApiOperation(value = "根据id查询订单详情", notes = "根据id查询订单详情")
    @GetMapping("/getById/{orderId}")
    public ResultBean<Order> queryById(@PathVariable(value = "orderId") String orderId){
        Order order = orderServer.queryById(Long.valueOf(orderId));
        return ResultBean.success(order);
    }

}
