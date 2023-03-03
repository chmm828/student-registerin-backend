package com.server.service;

import com.server.entity.SysPermission;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

/**
 * @author ： 
 * @date ：Created in  2022/11/7 13:19
 * @description：权限操作逻辑
 * @modified By：
 */


public interface SysPermissionService {
    /**
     *  分页查询
     * @param queryInfo 页码、页数大小、查询内容
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加权限数据
     * @param permission
     * @return
     */
    Result insert (SysPermission permission);

    /**
     * 删除权限数据
     * @param id
     * @return
     */
    Result delete(Long id);

    /**
     * 修改权限数据
     * @param permission
     * @return
     */
    Result update(SysPermission permission);

    /**
     * 查询所有的权限数据
     * @return
     */
    Result findAll();
}
