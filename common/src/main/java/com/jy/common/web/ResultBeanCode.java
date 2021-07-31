package com.jy.common.web;

import lombok.Getter;

@Getter
public enum ResultBeanCode {

    SUCCESS("200", "成功"),

    FAIL("1001", "失败"),

    ERROR("500","系统错误"),

    NOT_FOUND("404","路径不存在");

    String code;
    String message;


    ResultBeanCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
