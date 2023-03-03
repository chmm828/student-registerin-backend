package com.server.service;

import com.server.entity.Student;
import com.server.entity.Teacher;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

public interface TeacherService {
    /**
     * 分页查找老师信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加老师数据
     * @param teacher
     * @return
     */
    Result insert (Teacher teacher);

    /**
     * 删除老师数据
     * @param teacher
     * @return
     */
    Result delete(Teacher teacher);

    /**
     * 修改老师数据
     * @param teacher
     * @return
     */
    Result update(Teacher teacher);

    /**
     * 修改老师数据是否展示
     * @param teacher
     * @return
     */
    Result updateShow(Teacher teacher);

    /**
     * 查询老师数据，用于后台
     */

    Result findTeacherInfo();
}
