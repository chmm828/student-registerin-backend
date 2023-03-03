package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Teacher;

import java.util.List;

public interface TeacherMapper {
    /**
     * 分页查询 老师信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Teacher> findPage(String queryString);
    /**
     * 添加老师信息
     * @param teacher 老师数据
     */
    void insert(Teacher teacher);

    /**
     * 修改老师信息
     * @param teacher 老师数据
     */
    void update(Teacher teacher);

    /**
     * 修改老师信息是否展示
     * @param teacher 老师数据
     */
    void updateShow(Teacher teacher);
    /**
     * 删除老师数据(软删除）
     * @param teacher
     */
    void delete(Teacher teacher);

    /**
     * 查询教室数据。用于后台
     * @param
     */
    List<Teacher> findTeacherInfo();
}
