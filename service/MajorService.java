package com.server.service;

import com.server.entity.Major;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

/**
 * @program: 新生报道系统
 * @description: 专业信息管理操作逻辑接口
 * @author: 111
 * @create: 2022-10-24 00:40
 **/
public interface MajorService {
    /**
     * 分页查找专业信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加专业数据
     * @param major
     * @return
     */
    Result insert (Major major);

    /**
     * 删除专业数据
     * @param major
     * @return
     */
    Result delete(Major major);

    /**
     * 修改专业数据
     * @param major
     * @return
     */
    Result update(Major major);

    /**
     * 修改专业数据是否展示
     * @param major
     * @return
     */
    Result updateShow(Major major);

    /**
     * 查询专业信息,用于后台查询
     */

    Result findMajorInfo();
}
