package com.server.controller;

import com.server.entity.SysPermission;
import com.server.service.SysPermissionService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ： 
 * @date ：Created in  2022/11/7 14:49
 * @description：权限数据控制层
 * @modified By：
 */
@RestController//RestController==@controller+@ResponseBody
@Api(tags = "权限数据")
@RequestMapping("/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value = "分页查询权限")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return sysPermissionService.findPage(queryInfo);
    }

    @ApiOperation(value = "添加权限")
    @PostMapping("/insert")
    public Result insert(@RequestBody SysPermission permission){
        return sysPermissionService.insert(permission);
    }

    @ApiOperation(value = "修改权限")
    @PutMapping("/update")
    public Result update(@RequestBody SysPermission permission){
        return sysPermissionService.update(permission);
    }

    @ApiOperation(value = "删除权限")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Long id){
        return sysPermissionService.delete(id);
    }

    @ApiOperation(value = "查询所有的权限")
    @GetMapping("/findAll")
    public Result findAll(){
        return sysPermissionService.findAll();
    }
}
