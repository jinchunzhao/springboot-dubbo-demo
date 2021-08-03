package com.jy.user.serverimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.jy.api.user.UserServer;
import com.jy.common.exception.CastException;
import com.jy.common.pojo.User;
import com.jy.common.utils.ReflectUtil;
import com.jy.common.web.ResultBean;
import com.jy.common.web.ResultBeanCode;
import com.jy.user.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * 用户服务接口实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:52
 */
@Slf4j
@Component
@Service(interfaceClass = UserServer.class, timeout = 60000)
public class UserServerImpl implements UserServer {

    @Autowired
    private UserDao userDao;

    // can not find lambda cache for this entity [com.jy.common.pojo.User]
    // @Override
    // protected Class<User> currentModelClass() {
    // Type[] genericParamClassArray = ReflectUtil.getGenericParamClassArray(getClass());
    // if (genericParamClassArray == null || genericParamClassArray.length < 2) {
    // log.warn("Warn: {} not set the actual class on superclass generic parameter", getClass().getSimpleName());
    // return null;
    // }
    // return (Class<User>) genericParamClassArray[1];
    // }

    @Transactional
    @Override
    public ResultBean userRegister(User user) {
        int count = userDao.selectCount(new LambdaQueryWrapper<User>().eq(User::getUserName, user.getUserName()));

        if (count > 0) {
            String format = String.format("用户：【%s】，已存在，请勿重复注册", user.getUserName());
            CastException.cast(ResultBeanCode.FAIL.getCode(), format);
        }

        Date createdDate = new Date();
        user.setCreateTime(createdDate);
        user.setUpdateTime(createdDate);
        user.setRegTime(createdDate);
        user.setCreateUserId(0L);
        user.setUpdateUserId(0L);
        boolean save = SqlHelper.retBool(userDao.insert(user));
        if (save) {
            return ResultBean.success();
        } else {
            return ResultBean.failed();
        }
    }

    @Override
    public User queryOneById(Long userId) {
        User user = userDao.selectById(userId);
        user.setPassword(null);
        return user;
    }

    @Override
    public Page<User> queryPageList(String keyword, Page<User> page) {
        List<User> users = userDao.queryPageList(keyword, page);
        page.setRecords(users);
        return page;
    }
}
