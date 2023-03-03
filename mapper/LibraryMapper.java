package com.server.mapper;

import com.github.pagehelper.Page;
import com.server.entity.Library;

import java.util.List;

public interface LibraryMapper {
    /**
     * 分页查询 图书馆信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Library> findPage(String queryString);
    /**
     * 添加班级信息
     * @param library 图书馆数据
     */
    void insert(Library library);

    /**
     * 修改班级信息
     * @param library 图书馆数据
     */
    void update(Library library);

    /**
     * 修改班级信息是否展示
     * @param library 图书馆数据
     */
    void updateShow(Library library);
    /**
     * 删除班级数据(软删除）
     * @param library
     */
    void delete(Library library);

    /**
     * 查找图书馆展示数据
     */
    List<Library> findLibraryInfo();
}
