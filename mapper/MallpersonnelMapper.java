package com.server.mapper;

import com.server.entity.Mallpersonnel;
import com.server.entity.SysMenu;
import com.server.entity.SysPermission;
import com.server.entity.SysRole;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *用户相关的操作
 * @author  
 * @since   2022/10/23
 */
public interface MallpersonnelMapper {
    /**
     * 根据用户名获取用户对象
     * @param username
     * @return
     */
    Mallpersonnel findByUsername(String username);

        /**
     * 在JavaShopApplicationTests，里进行测试
     * 根据用户ID查询角色信息
     * @param pId
     * @return
     */
//    List<SysRole> findRoles(Integer id);
      List<SysRole>  findRoles(@Param("pId") Integer pId);

    /**
     * 根据用户ID查询菜单信息
     * @param pId
     * @return
     */
    List<SysMenu> findMenus(@Param("pId") Integer  pId);

    /**
     * 根据用户ID查询权限数据
     * @param pId
     * @return
     */
    List<SysPermission> findPermissions(@Param("pId") Integer pId);


    /**
     * 根据父级id和用户id查询子集菜单
     * @param id 父级id
     * @param pId 用户id
     * @return
     */
    List<SysMenu> findChildrenMenu(@Param("id") int id,@Param("pId") Integer  pId);

    /**
     * 分页查询用户信息
     * @param queryString 分页查询字符串
     * @return 返回分页数据
     */
    Page<Mallpersonnel> findPage(String queryString);

    /**
     * 添加用户信息
     * @param mallpersonnel 用户信息
     */
    void insert(Mallpersonnel mallpersonnel);

    /**
     * 修改用户信息
     * @param mallpersonnel 用户信息
     */
    void update(Mallpersonnel mallpersonnel);

    /**
     * 删除用户
     * @param id 用户ID
     */
    void delete(Integer id);

    /**
     * 根据用户中的角色列表，去添加用户的角色
     * @param pId
     * @param roleId
     */

    void insertUserRoles(@Param("pId") Integer pId,@Param("roleId") Long roleId);

    /**
     * 根据用户Id去删除角色列表
     * @param pId
     */
    void deleteByUserId(@Param("pId") Integer pId);

    /**
     * 根据用户id查询用的基本信息
     * @param pId
     * @return
     */
    Mallpersonnel findBypId(Integer pId);


    /**
     * 根据用户Id去删除角色信息
     * @param pId
     */
    void deleteRolesByUserId(Integer pId);

    /**
     * 根据邮件去修改密码
     * @param email
     * @param password
     */
    @Update("update mallpersonnel set `password` =#{password} where email = #{email}")
    void updatePwdByMail(@Param("email") String email,@Param("password") String password);

//    查找管理员信息
    List<Mallpersonnel> findAdminInfo();
}

