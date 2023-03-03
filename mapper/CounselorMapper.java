package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Counselor;

import java.util.List;

public interface CounselorMapper {
    /**
     * 分页查询 辅导员信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Counselor> findPage(String queryString);
    /**
     * 添加辅导员信息
     * @param counselor 辅导员数据
     */
    void insert(Counselor counselor);

    /**
     * 修改辅导员信息
     * @param counselor 辅导员数据
     */
    void update(Counselor counselor);

    /**
     * 修改辅导员信息是否展示
     * @param counselor 辅导员数据
     */
    void updateShow(Counselor counselor);

    /**
     * 删除辅导员数据(软删除）
     * @param counselor
     */
    void delete(Counselor counselor);

    /**
     * 查询辅导员信息，用于后台
     * @param
     */
    List<Counselor> findCounselorInfo();
}
