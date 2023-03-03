package com.server.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @program: java-jssb
 * @description: 分页的结果参数
 * @author:  
 * @create: 2021-10-23 12:28
 **/

@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult extends Result implements Serializable {
    @ApiModelProperty("分页总记录数")
    private  long total;//总记录数
    @ApiModelProperty(value = "分页的数据列表")
    private List<?> rows;//分页的数据

    public PageResult(long total, List< ? > list) {
        this.setFlag(true);
        this.setMessage("分页查询成功");
        this.total = total;
        this.rows = list;
    }

    /**
     * 直接返回分页数据
     * @param total 分页总条数
     * @param list 分页数据列表
     * @return
     */
    public  static  Result pageResult(long total, List<?> list){
        return  new PageResult(total,list);
    }
}
