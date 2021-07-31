package com.jy.common.exception;

import com.jy.common.web.ResultBeanCode;
import lombok.Data;

import java.util.Date;

/**
 * 自定义异常
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 11:23
 */
@Data
public class MyException extends RuntimeException {

    private String code = "400";
    private String msg;
    private Date timestamp;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.timestamp = new Date();
    }

    public MyException(ResultBeanCode resultBeanCode) {
        this.msg = resultBeanCode.getMessage();
        this.code = resultBeanCode.getCode();
        this.timestamp = new Date();
    }


    public MyException(String msg) {
        this.timestamp = new Date();
        this.msg = msg;
        this.code = ResultBeanCode.FAIL.getCode();
    }
    public MyException() { }


}
