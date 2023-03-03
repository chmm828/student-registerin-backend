package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Grade;

import java.util.List;

public interface GradeMapper {
    /**
     * 分页查询 年级信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Grade> findPage(String queryString);
    /**
     * 添加年级信息
     * @param grade 年级数据
     */
    void insert(Grade grade);

    /**
     * 修改年级信息
     * @param grade 年级数据
     */
    void update(Grade grade);

    /**
     * 修改年级信息是否展示
     * @param grade 年级数据
     */

    void updateShow(Grade grade);
    /**
     * 删除年级数据(软删除）
     * @param grade
     */
    void delete(Grade grade);

    /**
     * 查寻年级信息，用于后台
     * return grade
     */
    List<Grade> findGradeInfo();
}
