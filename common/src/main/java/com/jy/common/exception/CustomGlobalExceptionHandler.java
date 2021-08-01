package com.jy.common.exception;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.jy.common.web.ResultBean;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 自定义全局异常处理器
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 10:42
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());



    @Order(-1)
    @ResponseBody
    @ExceptionHandler(value = {MyException.class})
    public ResultBean ec(MyException e) {
        log.error("MyException异常:", e);
        return ResultBean.failed(e.getCode(),e.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResultBean ec(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException异常:", e);
        return ResultBean.failed(e.getLocalizedMessage());
    }

    /**
     * 捕捉MyBatisSystemException异常，并格式化输出
     *
     * @param ex
     *            异常
     * @param request
     *            http请求对象
     * @return 格式化返回值
     */
    @ExceptionHandler(value = {MyBatisSystemException.class})
    @ResponseBody
    public ResultBean mybatisSqlError(MyBatisSystemException ex, HttpServletRequest request) {
        log.error("MyBatisSystemException:{},请求路径:{}", ex, request.getRequestURI(), ex);
        return ResultBean.failed();
    }



    /**
     * 捕捉MybatisPlusException异常，并格式化输出
     *
     * @param ex
     *            异常
     * @param request
     *            http请求对象
     * @return 格式化返回值
     */
    @ExceptionHandler(value = {MybatisPlusException.class})
    @ResponseBody
    public ResultBean plusSqlError(MybatisPlusException ex, HttpServletRequest request) {
        log.error("MybatisPlusException:{},请求路径:{}", ex, request.getRequestURI(), ex);
        return ResultBean.failed();
    }
    /**
     * 捕捉BadSqlGrammarException异常，并格式化输出
     *
     * @param ex
     *            异常
     * @param request
     *            http请求对象
     * @return 格式化返回值
     */
    @ExceptionHandler(value = {BadSqlGrammarException.class})
    @ResponseBody
    public ResultBean badSqlError(BadSqlGrammarException ex, HttpServletRequest request) {
        log.error("BadSqlGrammarException:{},请求路径:{}", ex, request.getRequestURI(), ex);
        return ResultBean.failed();
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean notFount(Exception e,HttpServletRequest request) {
        log.error("Exception异常:", e);
        return ResultBean.failed();
    }
}
