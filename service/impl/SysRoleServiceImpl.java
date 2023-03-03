package com.server.service.impl;

import com.server.entity.SysPermission;
import com.server.entity.SysRole;
import com.server.mapper.SysPermissionMapper;
import com.server.mapper.SysRoleMapper;
import com.server.service.SysRoleService;
import com.server.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ： 
 * @date ：Created in  2022/11/7 13:37
 * @description：实现操作逻辑的类
 * @modified By：
 */
@Service
@Slf4j
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private   SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        log.info("开始权限数据分页-->页码{}，-->页数大小{}",queryInfo.getPageNumber(),queryInfo.getPageSize());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        log.info("查询-->{}",queryInfo.getQueryString());
        Page<SysRole> page = roleMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        log.info("分页总数据:{}",total);
        List<SysRole> result = page.getResult();
        result.forEach(item ->{
            //查询角色下的权限信息
          List <SysPermission>  permissions =   sysPermissionMapper.findByRoleId(item.getId());
          item.setPermissions(permissions);
        });

        return PageResult.pageResult(total,result);
    }

    @Transactional
    @Override
    public Result insert(SysRole role) {
        log.info("查询角色信息是否存在");
        SysRole roles = roleMapper.findByLabel(role.getLabel());
        if(roles!=null){
            return  Result.fail("该角色已经存在");
        }
        //插入角色信息
        roleMapper.insert(role);
        if(role.getPermissions().size()>0){
            log.info("添加对应的权限数据");
            role.getPermissions().forEach(item ->{
               roleMapper.insertPermissions(role.getId(),item.getId());
            });
        }
        redisUtil.delKey("uerInfo"+ SecurityUtil.getUsername());
        return Result.success("添加角色信息成功！");
    }

    @Override
    public Result delete(Long id) {
        log.info("查询该角色下是否还有权限信息");
        System.out.println("==========+++++++++++++++++++++======="+sysPermissionMapper.findByRoleId(id).size());
      if(sysPermissionMapper.findByRoleId(id).size()>0){
          return Result.fail("删除失败，该角色下拥有权限信息，请先删除对应的权限信息！");
      }
        roleMapper.delete(id);
        redisUtil.delKey("uerInfo"+ SecurityUtil.getUsername());
        return Result.success("删除成功！");
    }

    @Transactional
    @Override
    public Result update(SysRole role) {

       roleMapper.update(role);
        System.out.println("==========+++++++++++++++++++++======="+role.getPermissions().size());
        if(role.getPermissions().size()>=0){
            log.info("1、先删除对应的权限数据");
            roleMapper.deleteByPermissionId(role.getId());
            log.info("2、再添加对应的权限数据");
            role.getPermissions().forEach(item ->{
                roleMapper.insertPermissions(role.getId(),item.getId());
            });
        }
        redisUtil.delKey("uerInfo"+ SecurityUtil.getUsername());
        return Result.success("修改角色信息成功！");
    }

    @Override
    public Result findAll() {
        return Result.success("查询所有角色信息成功！",roleMapper.findAll());
    }
}
