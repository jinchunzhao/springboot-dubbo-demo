package com.jy.common.exception;


import com.jy.common.web.ResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
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
@Controller
@ControllerAdvice
@Order(-1)//值越小优先级越高
public class CustomGlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截业务异常
     */
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResultBean bussiness(RuntimeException e) {
        log.error("业务异常:", e);
        return ResultBean.failed();
    }

    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public ResultBean ec(MyException e) {
        log.error("业务异常:", e);
        return ResultBean.failed(e.getCode(),e.getMsg());
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultBean ec(MethodArgumentNotValidException e) {
        log.error("业务异常:", e);
        return ResultBean.failed(e.getLocalizedMessage());
    }


    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean notFount(Exception e,HttpServletRequest request) {
        log.error("运行时异常:", e);
        return ResultBean.failed();
    }


}
