package com.server.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ： 
 * @date ：Created in  2022/11/14 12:48
 * @description：邮件对象
 * @modified By：
 */
@Data
@ApiModel(value = "邮件发送内容")
public class MailVo  implements Serializable {
    @ApiModelProperty(value = "是否是html格式")
    private  boolean html=false;

    @ApiModelProperty(value = "接收人（可以多个）")
    private  String[] receivers;

    @ApiModelProperty(value ="邮件主题")
    private String subject;

    @ApiModelProperty(value ="邮件内容")
    private String content;
}
