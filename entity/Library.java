package com.server.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value="图书管图片id", description="")
public class Library implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书管图片id")
    private Integer libraryId;

    @ApiModelProperty(value = "操作管理员Id")
    private Integer adminId;

    @ApiModelProperty(value = "图片名称")
    private String libraryName;

    @ApiModelProperty(value = "图片")
    private String libraryImg;

    @ApiModelProperty(value = "描述")
    private String libraryDes;

    @ApiModelProperty(value = "发布时间")
    private String libraryCreatTime;

    @ApiModelProperty(value = "是否展示 1展示 2不展示")
    private Boolean libraryStatus;

    @ApiModelProperty(value = "是否删除 1 删除，0 不删除")
    private Boolean libraryIsDelete;

    @ApiModelProperty(value = "发布的管理员信息")
    private List<Mallpersonnel> mallpersonnels;

    private   List<Image> imageList ;

}
