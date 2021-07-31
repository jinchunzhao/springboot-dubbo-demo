package com.jy.user.serverimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.api.user.UserServer;
import com.jy.common.pojo.User;
import com.jy.user.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 用户服务接口实现类
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:52
 */
@Slf4j
@Component
@Service(interfaceClass = UserServer.class)
public class UserServerImpl extends ServiceImpl<UserDao, User> implements UserServer {
}
