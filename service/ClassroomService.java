package com.server.service;

import com.server.entity.Classroom;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

public interface ClassroomService {
    /**
     * 分页查找教室信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加教室数据
     * @param classroom
     * @return
     */
    Result insert (Classroom classroom);

    /**
     * 删除教室数据
     * @param classroom
     * @return
     */
    Result delete(Classroom classroom);

    /**
     * 修改教室数据
     * @param classroom
     * @return
     */
    Result update(Classroom classroom);

    /**
     * 修改教室数据是否展示
     * @param classroom
     * @return
     */
    Result updateShow(Classroom classroom);

    /**
     *  展示教室数据信息
     */

    Result findClassroomInfo();
}
