package com.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value="老师实体对象", description="")
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "老师工号")
    private Integer teacherId;

    @ApiModelProperty(value = "所在学院，外键")
    private Integer collegeId;

    @ApiModelProperty(value = "老师名字")
    private String teacherName;

    @ApiModelProperty(value = "性别")
    private Integer teacherSex;

    @ApiModelProperty(value = "老师介绍")
    private String teacherDes;

    @ApiModelProperty(value = "宣传图片")
    private String teacherImg;

    @ApiModelProperty(value = "联系方式")
    private String teacherPhone;

    @ApiModelProperty(value = "创建时间")
    private String teacherCreateTime;

    @ApiModelProperty(value = "0 禁用，1正常")
    private Boolean teacherStatus;

    @ApiModelProperty(value = "是否删除，0不删除，1删除")
    private Boolean teacherIsDelete;

    @ApiModelProperty(value = "学院信息")
    private List<College> colleges;
}
