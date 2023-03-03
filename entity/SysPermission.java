package com.server.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ： 
 * @date ：Created in  2022/10/24 17:14
 * @description：数据权限
 * @modified By：
 */
@Data
public class SysPermission {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "数据权限标签名称")
    private String label;

    @ApiModelProperty(value = "数据权限标签值")
    private String code;

    @ApiModelProperty(value = "显示状态（0不显示 ，1显示）")
    private boolean status;
}
