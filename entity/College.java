package com.server.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 学院实体
 */
@Data
public class College implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学院主键")
    private Integer collegeId;

    @ApiModelProperty(value = "学院名字")
    private String collegeName;

    @ApiModelProperty(value = "学院封面")
    private String collegeImg;

    @ApiModelProperty(value = "学院描述")
    private String collegeDes;

    @ApiModelProperty(value = "学院代号")
    private String collegeNumber;

    @ApiModelProperty(value = "学院创建时间")
    private String collegeCreateTime;

    @ApiModelProperty(value = "是否删除 0正常 1删除")
    private Boolean collegeIsDelete;

    @ApiModelProperty(value = "是否显示")
    private Boolean collegeStatus;

    @ApiModelProperty(value = "专业实体")
    private List<Major> majors;

    @ApiModelProperty(value = "学院老师")
    private List<Teacher> teachers;
}
