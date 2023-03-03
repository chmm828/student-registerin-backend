package com.server.service;

import com.server.entity.Grade;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

public interface GradeService {
    /**
     * 分页查找年级信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加年级数据
     * @param grade
     * @return
     */
    Result insert (Grade grade);

    /**
     * 删除年级数据
     * @param grade
     * @return
     */
    Result delete(Grade grade);

    /**
     * 修改年级数据
     * @param grade
     * @return
     */
    Result update(Grade grade);

    /**
     * 修改年级数据是否展示
     * @param grade
     * @return
     */
    Result updateShow(Grade grade);

    /**
     * 查询年级数据是否展示
     * @param 
     * @return grade
     */
    Result findGradeInfo();
}
