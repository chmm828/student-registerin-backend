package com.server.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * @author ： 
 * @date ：Created in  2022/10/24 17:01
 * @description：角色信息实体
 * @modified By：
 */
@Data
public class SysRole {

    @ApiModelProperty(value = "主键）")
    private Long id;

    @ApiModelProperty(value = "角色值")
    private String label;

    @ApiModelProperty(value = "角色标签")
    private String code;

    @ApiModelProperty(value = "显示状态（0不显示 ，1显示）")
    private boolean status;

    @ApiModelProperty(value = "菜单列表")
    private List<SysMenu> menus;

    @ApiModelProperty(value = "权限列表")
    private List<SysPermission> permissions;
}
