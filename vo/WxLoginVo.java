package com.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "登录参数")
public class WxLoginVo {
    @ApiModelProperty(value = "学生学号",dataType = "String",required = true)
    private String studentId;
    @ApiModelProperty(value = "密码",dataType = "String",required = true)
    private String password;

}
