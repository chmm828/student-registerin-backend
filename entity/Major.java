package com.server.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 专业实体
 */

@Data
public class Major implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "专业主键")
    private Integer majorId;

    @ApiModelProperty(value = "学院id")
    private Integer collegeId;

    @ApiModelProperty(value = "专业名称")
    private String majorName;

    @ApiModelProperty(value = "专业描述")
    private String majorDes;

    @ApiModelProperty(value = "创建时间")
    private String majorCreatTime;

    @ApiModelProperty(value = "专业代号，唯一值")
    private String majorNumber;

    @ApiModelProperty(value = "是否开启")
    private Boolean majorStatus;

    @ApiModelProperty(value = "1删除，0不删除")
    private Boolean majorIsDelete;

    @ApiModelProperty(value = "学院实体")
    private List<College> colleges;

    @ApiModelProperty(value = "班级实体")
    private List<ClassEntity> classEntities;

}
