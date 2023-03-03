package com.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value="教室实体对象", description="")
public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教室图片主键")
    private Integer classroomId;

    @ApiModelProperty(value = "操作管理员Id")
    private Integer adminId;

    @ApiModelProperty(value = "名称")
    private String classroomName;

    @ApiModelProperty(value = "教室图片")
    private String classroomImg;

    @ApiModelProperty(value = "描述")
    private String classroomDes;

    @ApiModelProperty(value = "发布时间")
    private String classroomCreatTime;

    @ApiModelProperty(value = "1 展示，2不展示")
    private Boolean classroomStatus;

    @ApiModelProperty(value = "0 不删除， 1删除")
    private Boolean classroomIsDelete;

    @ApiModelProperty(value = "发布的管理员信息")
    private List<Mallpersonnel> mallpersonnels;
}
