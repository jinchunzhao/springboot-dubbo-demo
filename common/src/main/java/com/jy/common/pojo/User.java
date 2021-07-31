package com.jy.common.pojo;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerColumnDefinition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jy.common.pojo.base.IdFieldEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户实体类
 * 
 * @author jinchunzhao
 * @version 1.0
 * @date 2021-07-31 15:19
 */
@Data
@TableName(value = "sys_user")
public class User extends IdFieldEntity {

    @ApiModelProperty(value = "用户昵称")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty(value = "用户手机号")
    @TableField(value = "tel")
    private String tel;

    @ApiModelProperty(value = "注册时间")
    @TableField(value = "reg_time")
    private String regTime;

}
