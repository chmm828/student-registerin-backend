package com.server.controller;

import com.server.entity.ClassEntity;
import com.server.service.ClassService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 班级信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/class")
@Api(tags = "班级信息管理接口")
public class ClassController {
    @Autowired
    ClassService classService;

    @ApiOperation("分页获取班级信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return classService.findPage(queryInfo);
    }

    @ApiOperation("添加班级信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody ClassEntity classEntity){
        return classService.insert(classEntity);
    }

    @ApiOperation("修改班级信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody ClassEntity classEntity){
        return classService.update(classEntity);
    }

    @ApiOperation("修改班级信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody ClassEntity classEntity){
        return classService.updateShow(classEntity);
    }

    @ApiOperation("删除班级信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody ClassEntity classEntity){
        return classService.delete(classEntity);
    }

    @ApiOperation("查询班级信息接口")
    @GetMapping("/findClassInfo")
    public Result findClassInfo () {
        return classService.findClassInfo();
    }
}
