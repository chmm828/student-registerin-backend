package com.server.utils;

import lombok.Data;

/**
 * @program: java-jssb
 * @description: 分页查询
 * @author:  
 * @create: 2021-10-23 12:32
 **/
@Data
public class QueryInfo {
    private Integer pageNumber;//第几页
    private Integer pageSize;//一页多少条数据
    private String queryString;//查询的内容

}
