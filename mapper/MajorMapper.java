package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Major;

import java.util.List;

public interface MajorMapper {
    /**
     * 分页查询 专业信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Major> findPage(String queryString);
    /**
     * 添加专业信息
     * @param major 专业数据
     */
    void insert(Major major);

    /**
     * 修改专业信息
     * @param major 专业数据
     */
    void update(Major major);

    /**
     * 修改专业信息是否展示
     * @param major 专业数据
     */
    void updateShow(Major major);
    /**
     * 删除专业数据(软删除）
     * @param major
     */
    void delete(Major major);

    /**
     *查询专业信息，用于后台
     * @param
     */
    List<Major> findMajorInfo();
}
