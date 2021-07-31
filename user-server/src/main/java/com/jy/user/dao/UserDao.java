package com.jy.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * user dao层
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:46
 */
@Mapper
public interface UserDao extends BaseMapper<User> {


}
