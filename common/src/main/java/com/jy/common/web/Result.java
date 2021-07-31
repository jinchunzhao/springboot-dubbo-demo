package com.jy.common.web;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 响应实体
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 10:48
 */
public class Result<T> {

    @ApiModelProperty(value = "编码：200, 404，500")
    private String code;

    @ApiModelProperty(value = "消息")
    private String msg;

    @ApiModelProperty(value = "时间戳")
    private Date timestamp;

    @ApiModelProperty(value = "数据")
    private T data;

    public Result() {
        this.timestamp = new Date();
    }

    public Result( String code, String msg, T data) {
        this.timestamp = new Date();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg) {
        this.timestamp = new Date();
        this.code = code;
        this.msg = msg;
    }


    public static <T> Result<T> success() {

        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(T data) {

        return build(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> success(ResultCode resultCode, T data) {

        return build(resultCode, data);
    }

    public static <T> Result<T> failed() {

        return new Result(ResultCode.FAIL);
    }

    public static <T> Result<T> failed(T data) {

        return build(ResultCode.FAIL, data);
    }

    public static <T> Result<T> failed(ResultCode resultCode, T data) {

        return build(resultCode, data);
    }

    public static <T> Result<T> build(ResultCode resultCode, T data) {
        return new Result(resultCode, data);
    }


    public Result(ResultCode resultCode,T data) {
        this(resultCode.getCode(), resultCode.getMessage(),data);
    }

    public Result(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMessage());
    }

}
