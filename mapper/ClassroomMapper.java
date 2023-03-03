package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Classroom;
import com.server.entity.Library;

import java.util.List;

public interface ClassroomMapper {
    /**
     * 分页查询 教室信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Classroom> findPage(String queryString);
    /**
     * 添加班级信息
     * @param classroom 教室数据
     */
    void insert(Classroom classroom);

    /**
     * 修改班级信息
     * @param classroom 教室数据
     */
    void update(Classroom classroom);

    /**
     * 修改班级信息是否展示
     * @param classroom 教室数据
     */
    void updateShow(Classroom classroom);
    /**
     * 删除班级数据(软删除）
     * @param classroom
     */
    void delete(Classroom classroom);

    List<Classroom> findClassroomInfo();
}
