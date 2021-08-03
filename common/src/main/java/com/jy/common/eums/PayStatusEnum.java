package com.jy.common.eums;

import lombok.Getter;

/**
 * 支付状态 枚举类
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:36
 */
@Getter
public enum PayStatusEnum {

    NON_PAY(0, "未支付"), IN_PAY(1, "支付中"), PAID(2, "已支付");

    private Integer code;

    private String name;

    PayStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
