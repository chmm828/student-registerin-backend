package com.server.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ： 
 * @date ：Created in  2022/10/24 17:08
 * @description：菜单
 * @modified By：
 */
@Data
public class SysMenu {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "菜单路径")
    private String path;

    @ApiModelProperty(value = "菜单图标")
    private String icon;

    /**
     * 菜单标题
     */
    @ApiModelProperty(value = "菜单标题")
    private String title;

    /**
     * 前端组件
     */
    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "父级菜单")
    private Integer parentId;

    /**
     * 子菜单
     */
    @ApiModelProperty(value = "子菜单")
    private List<SysMenu> children;

    @ApiModelProperty(value = "显示状态（0不显示 ，1显示）")
    private boolean status;

}
