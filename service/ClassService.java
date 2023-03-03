package com.server.service;

import com.server.entity.ClassEntity;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

public interface ClassService {
    /**
     * 分页查找班级信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加班级数据
     * @param classEntity
     * @return
     */
    Result insert (ClassEntity classEntity);

    /**
     * 删除班级数据
     * @param classEntity
     * @return
     */
    Result delete(ClassEntity classEntity);

    /**
     * 修改班级数据
     * @param classEntity
     * @return
     */
    Result update(ClassEntity classEntity);

    /**
     * 修改班级数据是否展示
     * @param classEntity
     * @return
     */
    Result updateShow(ClassEntity classEntity);

    /**
     * 查询班级信息
     * @return classEntity
     */
    Result findClassInfo();
}
