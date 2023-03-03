package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Canteen;

import java.util.List;

public interface CanteenMapper {
    /**
     * 分页查询 食堂信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Canteen> findPage(String queryString);
    /**
     * 添加班级信息
     * @param canteen 食堂数据
     */
    void insert(Canteen canteen);

    /**
     * 修改班级信息
     * @param canteen 食堂数据
     */
    void update(Canteen canteen);

    /**
     * 修改班级信息是否展示
     * @param canteen 食堂数据
     */
    void updateShow(Canteen canteen);
    /**
     * 删除班级数据(软删除）
     * @param canteen
     */
    void delete(Canteen canteen);

    List<Canteen> findCanteenInfo();
}
