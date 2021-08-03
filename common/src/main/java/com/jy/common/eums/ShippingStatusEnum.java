package com.jy.common.eums;

import lombok.Getter;

/**
 * 发货状态 枚举类
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:39
 */
@Getter
public enum ShippingStatusEnum {

    NON_SHIPMENTS(0, "未发货"), SHIPPED(1, "已发货"), RECEIVED(2, "已收货");

    private Integer code;

    private String name;

    ShippingStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
