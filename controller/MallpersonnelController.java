package com.server.controller;

import com.server.entity.Mallpersonnel;
import com.server.service.MallpersonnelService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author ： 
 * @date ：Created in  2022/11/9 16:34
 * @description：用户管理控制器
 * @modified By：
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户管理")
public class MallpersonnelController {
    @Autowired
    private MallpersonnelService mallpersonnelService;


    @ApiOperation(value = "分页查询")
    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return mallpersonnelService.findPage(queryInfo);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/insert")
    public Result insert(@RequestBody Mallpersonnel mallpersonnel){
        return mallpersonnelService.insert(mallpersonnel);
    }

    @ApiOperation(value = "修改用户信息")
    @PutMapping("/update")
    public Result update(@RequestBody Mallpersonnel mallpersonnel){
        return mallpersonnelService.update(mallpersonnel);
    }

    @ApiOperation(value = "删除用户信息")
    @DeleteMapping("/delete/{pId}")
    public Result delete(@PathVariable("pId")Integer pId){
        return mallpersonnelService.delete(pId);
    }

    @ApiOperation(value = "获取管理员信息")
    @GetMapping("/findAdminInfo")
    public Result findAdminInfo(){
        return mallpersonnelService.findAdmin();
    }

}
