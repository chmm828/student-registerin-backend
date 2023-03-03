package com.server.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: java-jssb
 * @description: 后端给前端的结果
 * @author:  
 * @create: 2021-10-23 12:13
 **/
@Data
@ApiModel(value = "响应参数")
public class Result implements Serializable {
    @ApiModelProperty(value = "是否成功标识",dataType = "String")
    private boolean flag;//状态码，响应给前端是否成功的标识200成功，500失败
    @ApiModelProperty(value = "响应信息",dataType = "String")
    private  String message;//响应信息
    @ApiModelProperty(value = "响应数据",dataType = "Object")
    private  Object data;//返回对象

    public Result() {
    }

    public Result(boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, String message) {
        this.flag =  flag;
        this.message = message;
    }

    /**
     * 响应成功
     * @param message
     * @param data
     * @return
     */
    public static Result success(String message, Object data){
        return new Result(true,message,data);
    }
    /**
     * 响应成功
     * @param message
     * @param
     * @return
     */
    public static Result success(String message){
        return new Result(true,message);
    }

    /**
     * 响应失败
     * @param message
     * @return
     */
    public  static  Result fail(String message){
        return  new Result(false,message);
    }
}
