package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.ClassEntity;
import com.server.entity.College;

import java.util.List;

public interface ClassMapper {
    /**
     * 分页查询 班级信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<ClassEntity> findPage(String queryString);
    /**
     * 添加班级信息
     * @param classEntity 班级数据
     */
    void insert(ClassEntity classEntity);

    /**
     * 修改班级信息
     * @param classEntity 班级数据
     */
    void update(ClassEntity classEntity);

    /**
     * 修改班级信息是否展示
     * @param classEntity 班级数据
     */
    void updateShow(ClassEntity classEntity);
    /**
     * 删除班级数据(软删除）
     * @param classEntity
     */
    void delete(ClassEntity classEntity);

    /**
     * 查询班级信息，用于后台
     */
    List<ClassEntity> findClassInfo();
}
