package com.jy.common.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.common.page.PageParam;

/**
 * 基础BaseController
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 17:58
 */
public class BaseController {

    /**
     * 构建mybatis分页插件对象 pageNum 大于0
     *
     * @param param
     *        分页参数
     * @return 分页对象
     */
    public Page buildPage(PageParam param) {
        return new Page(param.getPageNum(), param.getPageSize());
    }

    /**
     * 解决字符串转date失败
     *
     * @param request
     * @param binder
     */
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
