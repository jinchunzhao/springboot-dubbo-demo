package com.jy.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * user dao层
 *
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:46
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 用户分页列表查询
     * 
     * @param keyword
     *            查询参数
     * @param page
     *            分页参数
     * @return 结果信息
     */
    List<User> queryPageList(@Param("keyword") String keyword, @Param("page") Page<User> page);
}
