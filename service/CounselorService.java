package com.server.service;

import com.server.entity.Counselor;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

public interface CounselorService {
    /**
     * 分页查找辅导员信息
     * @param queryInfo
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加辅导员数据
     * @param counselor
     * @return
     */
    Result insert (Counselor counselor);

    /**
     * 删除辅导员数据
     * @param counselor
     * @return
     */
    Result delete(Counselor counselor);

    /**
     * 修改辅导员数据
     * @param counselor
     * @return
     */
    Result update(Counselor counselor);

    /**
     * 修改辅导员数据是否展示
     * @param counselor
     * @return
     */
    Result updateShow(Counselor counselor);

    /**
     * 查询辅导员信息，用于后台
     * @param
     * @return
     */
    Result findCounselorInfo();
}
