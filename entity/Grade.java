package com.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value="年级对象", description="")
public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "年级id")
    private Integer gradeId;

    @ApiModelProperty(value = "年级名字")
    private String gradeName;

    @ApiModelProperty(value = "年级创建时间")
    private String gradeCreatTime;

    @ApiModelProperty(value = "年级状态，是否展示")
    private Boolean gradeStatus;

    @ApiModelProperty(value = "是否删除 0未删除，1删除")
    private Boolean gradeIsDelete;

}
