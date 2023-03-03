package com.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 班级实体
 */
@Data
@ApiModel(value="班级实体对象", description="")
public class ClassEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班级ID")
    private Integer classId;

    @ApiModelProperty(value =  "专业ID")
    private Integer majorId;

    @ApiModelProperty(value = "班级名称")
    private String className;

    @ApiModelProperty(value = "班级描述")
    private String classDes;

    @ApiModelProperty(value = "班级代号")
    private String classNumber;

    @ApiModelProperty(value = "创建时间")
    private String classCreatTime;

    @ApiModelProperty(value = "是否删除 0 未删除 1删除")
    private Boolean classIsDelete;

    @ApiModelProperty(value = "是否展示 0不展示，1展示")
    private Boolean classStatus;

    @ApiModelProperty(value = "所在专业")
    private List<Major> majors;

    @ApiModelProperty(value = "所在学院")
    private List<College> colleges;

}
