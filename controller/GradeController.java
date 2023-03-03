package com.server.controller;

import com.server.entity.Grade;
import com.server.service.GradeService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 年级信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/grade")
@Api(tags = "年级信息管理接口")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @ApiOperation("分页获取年级信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return gradeService.findPage(queryInfo);
    }

    @ApiOperation("添加年级信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody Grade grade){
        return gradeService.insert(grade);
    }

    @ApiOperation("修改年级信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody Grade grade){
        return gradeService.update(grade);
    }

    @ApiOperation("修改年级信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody Grade grade){
        return gradeService.updateShow(grade);
    }

    @ApiOperation("删除年级信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody Grade grade){
        return gradeService.delete(grade);
    }

    @ApiOperation("查询年级信息接口")
    @GetMapping("/findGradeInfo")
    public Result findGradeInfo() {
        return gradeService.findGradeInfo();
    }
}
