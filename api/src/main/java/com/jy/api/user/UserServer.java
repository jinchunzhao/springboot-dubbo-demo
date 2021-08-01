package com.jy.api.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.common.pojo.User;
import com.jy.common.web.ResultBean;

import java.net.UnknownServiceException;

/**
 * 用户 服务service接口
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:50
 */
public interface UserServer extends IService<User> {

    /**
     * 用户注册
     *
     * @param user
     *        参数信息
     * @return
     *        结果信息
     * @throws Exception
     *         任何异常
     */
    ResultBean userRegister(User user);
}
