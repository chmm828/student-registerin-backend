package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.College;

import java.util.List;

public interface CollegeMapper {
    /**
     * 分页查询 学院信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<College> findPage(String queryString);
    /**
     * 添加学院信息
     * @param college 学院数据
     */
    void insert(College college);

    /**
     * 修改学院信息
     * @param college 学院数据
     */
    void update(College college);

    /**
     * 修改学院信息是否展示
     * @param college 学院数据
     */
    void updateShow(College college);

    /**
     * 删除学院数据(软删除）
     * @param college
     */
    void delete(College college);

    /**
     * 查询学院信息，用于后台录入
     * @return
     */
    List<College> findCollegeInfo();


}
