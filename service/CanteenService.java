package com.server.service;

import com.server.entity.Canteen;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

public interface CanteenService {
    /**
     * 分页查找食堂信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加食堂数据
     * @param canteen
     * @return
     */
    Result insert (Canteen canteen);

    /**
     * 删除食堂数据
     * @param canteen
     * @return
     */
    Result delete(Canteen canteen);

    /**
     * 修改食堂数据
     * @param canteen
     * @return
     */
    Result update(Canteen canteen);

    /**
     * 修改食堂数据是否展示
     * @param canteen
     * @return
     */
    Result updateShow(Canteen canteen);

    /**
     * 查找食堂信息
     */
    Result findCanteen();
}
