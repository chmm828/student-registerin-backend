package com.server.service;

import com.server.entity.Library;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

public interface LibraryService {
    /**
     * 分页查找图书馆信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加图书馆数据
     * @param library
     * @return
     */
    Result insert (Library library);

    /**
     * 删除图书馆数据
     * @param library
     * @return
     */
    Result delete(Library library);

    /**
     * 修改图书馆数据
     * @param library
     * @return
     */
    Result update(Library library);

    /**
     * 修改图书馆数据是否展示
     * @param library
     * @return
     */
    Result updateShow(Library library);


    /**
     *
     * 查找图书馆信息展示
     * @return
     */
    Result findLibraryInfo();
}
