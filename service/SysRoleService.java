package com.server.service;

import com.server.entity.SysRole;
import com.server.utils.QueryInfo;
import com.server.utils.Result;

/**
 * @author ： 
 * @date ：Created in  2022/11/7 13:19
 * @description：权限操作逻辑
 * @modified By：
 */


public interface SysRoleService {
    /**
     *  分页查询
     * @param queryInfo 页码、页数大小、查询内容
     * @return
     */
    Result findPage(QueryInfo queryInfo);

    /**
     * 添加角色数据
     * @param role
     * @return
     */
    Result insert (SysRole role);

    /**
     * 删除角色数据
     * @param id
     * @return
     */
    Result delete(Long id);

    /**
     * 修改角色数据
     * @param  role
     * @return
     */

    Result update(SysRole role);

    Result findAll();

}
