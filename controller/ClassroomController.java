package com.server.controller;

import com.server.entity.ClassEntity;
import com.server.entity.Classroom;
import com.server.service.ClassService;
import com.server.service.ClassroomService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 教室信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/classroom")
@Api(tags = "教室信息管理接口")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;

    @ApiOperation("分页获取教室信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return classroomService.findPage(queryInfo);
    }

    @ApiOperation("添加教室信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody Classroom classroom){
        return classroomService.insert(classroom);
    }

    @ApiOperation("修改教室信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody  Classroom classroom){
        return classroomService.update(classroom);
    }

    @ApiOperation("修改教室信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody  Classroom classroom){
        return classroomService.updateShow(classroom);
    }

    @ApiOperation("删除教室信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody  Classroom classroom){
        return classroomService.delete(classroom);
    }

    @ApiOperation("查找教室信息接口")
    @GetMapping("/findClassroomInfo")
    public Result findClassroomInfo() {
        return classroomService.findClassroomInfo();
    }
}
