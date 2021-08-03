package com.jy.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.api.user.UserServer;
import com.jy.common.base.BaseController;
import com.jy.common.page.PageParam;
import com.jy.common.pojo.Order;
import com.jy.common.pojo.User;
import com.jy.common.web.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理接口
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-08-01 9:28
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理", tags = {"用户管理相关接口"})
public class UserController extends BaseController {

    @Reference
    private UserServer userServer;

    /**
     * 用户列表查询
     *
     * @param pageParam
     *            分页信息
     * @return 结果信息
     */
    @ResponseBody
    @ApiOperation(value = "用户列表查询", notes = "用户列表分页查询")
    @PostMapping("/list")
    public ResultBean<Page<User>> list(@Validated @RequestBody PageParam<String> pageParam) {
        Page<User> page = userServer.queryPageList(pageParam.getParam(), buildPage(pageParam));
        return ResultBean.success(page);
    }

    /**
     * 用户注册
     *
     * @param user
     *            参数信息
     * @return 结果信息
     * @throws Exception
     *             任何异常
     */
    @ResponseBody
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("/register")
    public ResultBean userRegister(@Validated @RequestBody User user) throws Exception {
        return userServer.userRegister(user);
    }
}
