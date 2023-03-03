package com.server.controller;

import com.server.entity.Teacher;
import com.server.service.TeacherService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 老师信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/teacher")
@Api(tags = "老师信息管理接口")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @ApiOperation("分页获取老师信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo) {
        return teacherService.findPage(queryInfo);
    }

    @ApiOperation("添加老师信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody Teacher teacher) {
        return teacherService.insert(teacher);
    }

    @ApiOperation("修改老师信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody Teacher teacher) {
        return teacherService.update(teacher);
    }

    @ApiOperation("修改老师信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody Teacher teacher) {
        return teacherService.updateShow(teacher);
    }

    @ApiOperation("删除老师信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody Teacher teacher) {
        return teacherService.delete(teacher);
    }

    @ApiOperation("查询老师信息接口")
    @GetMapping("/findTeacherInfo")
    public Result findTeacherInfo() {
        return teacherService.findTeacherInfo();
    }
}
