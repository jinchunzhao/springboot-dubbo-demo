package com.jy.common.eums;

import lombok.Getter;

/**
 * 订单状态枚举类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:31
 */
@Getter
public enum OrderStatusEnum {

    UNCONFIRMED(0,"未确认"),
    CONFIRMED(1,"已确认"),
    CANCELLED(2,"已取消"),
    INVALID(3,"无效"),
    REFUND(4,"退款");

    private Integer code;

    private String name;

    OrderStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
