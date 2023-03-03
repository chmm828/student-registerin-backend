package com.server.controller;

import com.server.entity.Canteen;
import com.server.service.CanteenService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 食堂信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/canteen")
@Api(tags = "食堂信息管理接口")
public class CanteenController {
    @Autowired
    CanteenService canteenService;

    @ApiOperation("分页获取食堂信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return canteenService.findPage(queryInfo);
    }

    @ApiOperation("添加食堂信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody Canteen canteen){
        return canteenService.insert(canteen);
    }

    @ApiOperation("修改食堂信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody Canteen canteen){
        return canteenService.update(canteen);
    }

    @ApiOperation("修改食堂信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody Canteen canteen){
        return canteenService.updateShow(canteen);
    }

    @ApiOperation("删除食堂信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody Canteen canteen){
        return canteenService.delete(canteen);
    }

    @ApiOperation("查找食堂信息")
    @GetMapping("/findCanteenInfo")
    public Result findCanteenInfo() {
        return canteenService.findCanteen();
    }
}
