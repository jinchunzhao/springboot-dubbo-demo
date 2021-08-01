package com.jy.common.pojo;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerColumnDefinition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jy.common.pojo.base.IdFieldEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

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

    @NotBlank(message = "用户名不能为空")
    @Length(max = 25,message="用户名字符长度不能超过25位")
    @ApiModelProperty(value = "用户昵称")
    @TableField(value = "user_name")
    private String userName;

    @NotBlank(message = "用户密码不能为空")
    @Length(max = 25,message="用户密码字符长度不能超过25位")
    @ApiModelProperty(value = "用户密码")
    @TableField(value = "password")
    private String password;

    @NotBlank(message = "用户手机号不能为空")
    @Length(min = 11,max = 11,message="用户手机号符长度必须是11位")
    @ApiModelProperty(value = "用户手机号")
    @TableField(value = "tel")
    private String tel;

    @ApiModelProperty(value = "注册时间")
    @TableField(value = "reg_time")
    private Date regTime;

}
