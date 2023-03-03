package com.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@ApiModel(value="食堂对象", description="")
public class Canteen  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "食堂ID")
    private Integer canteenId;

    @ApiModelProperty(value = "操作管理员的ID")
    private Integer adminId;

    @ApiModelProperty(value = "名称")
    private String canteenName;

    @ApiModelProperty(value = "图片")
    private String canteenImg;

    @ApiModelProperty(value = "描述")
    private String canteenDes;

    @ApiModelProperty(value = "发布时间")
    private String canteenCreatTime;

    @ApiModelProperty(value = "1 展示 0 不展示")
    private Boolean canteenStatus;

    @ApiModelProperty(value = "1 删除，0 不删除")
    private Boolean canteenIsDelete;

    @ApiModelProperty(value = "发布的管理员信息")
    private List<Mallpersonnel> mallpersonnels;
}
