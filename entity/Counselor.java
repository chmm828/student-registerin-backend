package com.server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value="辅导员对象", description="")
public class Counselor  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "辅导员ID")
    private Integer counselorId;

    @ApiModelProperty(value = "所在学院")
    private Integer collegeId;

    @ApiModelProperty(value = "名字")
    private String counselorName;

    @ApiModelProperty(value = "性别，0男1女")
    private Integer counselorSex;

    @ApiModelProperty(value = "联系方式")
    private String counselorPhone;

    @ApiModelProperty(value = "辅导员介绍")
    private String counselorDes;

    @ApiModelProperty(value = "宣传图片")
    private String counselorImg;

    @ApiModelProperty(value = "创建时间")
    private String counselorCreateTime;

    @ApiModelProperty(value = "是否展示，0不展示，1展示")
    private Boolean counselorStatus;

    @ApiModelProperty(value = "是否删除，0不删除，1删除")
    private Boolean counselorIsDelete;

    @ApiModelProperty(value = "所属学院信息")
    private List<College> colleges;

}
