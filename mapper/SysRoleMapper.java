package com.server.mapper;

import com.server.entity.SysRole;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： 
 * @date ：Created in  2022/11/8 8:45
 * @description：角色数据的增删改查
 * @modified By：
 */
public interface SysRoleMapper {
     /**
     * 添加角色信息
     * @param sysRole 角色数据
     */
    void insert(SysRole sysRole);

    /**
     * 修改角色信息
     * @param sysRole 角色数据
     */
    void update(SysRole sysRole);
    /**
     * 删除角色数据
     * @param id
     */
    void delete(Long id);
    /**
     * 分页查询
     * @param queryString
     * @return
     */
    Page<SysRole> findPage(String queryString);

    /**
     * 根据角色ID查询出角色信息
     * @param id
     * @return
     */
    SysRole findById(Long id);
    /**
     * 根据角色ID删除对应的权限数据
     * @param roleId
     */
    void deleteByPermissionId(@Param("roleId") Long roleId);

    /**
     * 添加角色权限信息
     * @param roleId 角色ID ,
     * @param permissionId 权限ID
     */

    void insertPermissions(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);

    /**
     * 根据角色名称查询是否存在角色信息
     * @param  label
     * @return
     */
    SysRole findByLabel(String label);

    /**
     * 查询所有的角色信息
     * @return
     */
    List<SysRole> findAll();

}
