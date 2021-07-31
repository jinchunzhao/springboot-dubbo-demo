package com.jy.common.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jy.common.pojo.base.IdFieldEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * 商品订单
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:25
 */
@Data
@TableName(value = "u_order")
public class Order extends IdFieldEntity {

    @ApiModelProperty(value = "用户ID")
    @TableField(value = "user_id")
    private Long userId;


    @ApiModelProperty(value = "订单状态 0未确认 1已确认 2已取消 3无效 4退款")
    @TableField(value = "order_status")
    private Integer orderStatus;

    @ApiModelProperty(value = "支付状态 0未支付 1支付中 2已支付")
    @TableField(value = "pay_status")
    private Integer payStatus;

    @ApiModelProperty(value = "发货状态 0未发货 1已发货 2已收货")
    @TableField(value = "shipping_status")
    private Integer shippingStatus;

    @ApiModelProperty(value = "收货地址")
    @TableField(value = "address")
    private String address;

    @ApiModelProperty(value = "收货人")
    @TableField(value = "consignee")
    private String consignee;

    @ApiModelProperty(value = "已付金额")
    @TableField(value = "money_paid")
    private BigDecimal moneyPaid;

    @ApiModelProperty(value = "支付金额")
    @TableField(value = "pay_amount")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "订单确认时间")
    @TableField(value = "confirm_time")
    private Date confirmTime;

    @ApiModelProperty(value = "支付时间")
    @TableField(value = "pay_time")
    private Date payTime;


    @ApiModelProperty(value = "下单人")
    @TableField(exist = false)
    private User user;



}
