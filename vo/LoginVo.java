package com.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ： 
 * @date ：Created in  2022/10/24 17:27
 * @description：
 * @modified By：
 */
@Data
@ApiModel(value = "登录参数")
public class LoginVo {
    @ApiModelProperty(value = "用户名",dataType = "String",required = true)
    private String username;
    @ApiModelProperty(value = "密码",dataType = "String",required = true)
    private String password;

    }

