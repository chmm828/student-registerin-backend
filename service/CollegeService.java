package com.server.service;

import com.server.entity.College;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

/**
 * @program: 新生报道系统
 * @description: 学院信息管理操作逻辑接口
 * @author: 111
 * @create: 2022-10-24 00:40
 **/
public interface CollegeService {

    /**
     * 分页查找学院信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加学院数据
     * @param college
     * @return
     */
    Result insert (College college);

    /**
     * 删除学院数据
     * @param college
     * @return
     */
    Result delete(College college);

    /**
     * 修改学院数据
     * @param college
     * @return
     */
    Result update(College college);

    /**
     * 修改学院数据是否展示
     * @param college
     * @return
     */
    Result updateShow(College college);

    /**
     * 查找学院数据，用于后台查询
     * @param
     * @return
     */
    Result findCollegeInfo();
}

