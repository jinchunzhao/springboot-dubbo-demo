package com.jy.api.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.common.exception.MyException;
import com.jy.common.pojo.User;
import com.jy.common.web.ResultBean;

/**
 * 用户 服务service接口
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:50
 */
public interface UserServer {

    /**
     * 用户注册
     *
     * @param user
     *            参数信息
     * @return 结果信息
     * @throws Exception
     *             任何异常
     */
    ResultBean userRegister(User user) throws Exception;

    /**
     * 根据条件查询数据
     * 
     * @param userId
     *            参数
     * @return 结果
     */
    User queryOneById(Long userId);

    /**
     * 用户分页列表查询
     *
     * @param keyword
     *            查询参数
     * @param page
     *            分页参数
     * @return 结果信息
     */
    Page<User> queryPageList(String keyword, Page<User> page);
}
