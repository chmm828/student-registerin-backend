package com.server.controller;

import com.server.entity.Student;
import com.server.service.StudentService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 学生信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/student")
@Api(tags = "学生信息管理接口")
public class StudentController {
    @Autowired
    StudentService studentService;

    @ApiOperation("分页获取学生信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return studentService.findPage(queryInfo);
    }

    @ApiOperation("获取学生个人信息接口")
    @PostMapping("/getStudentInfo/{studentId}")
    //@RequestBody:前端传来的json数据转换成对象
    public Result getStudentInfo(@PathVariable("studentId")String studentId){
        return studentService.getStudentInfo(studentId);
    }

    @ApiOperation("添加学生信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody Student student){
        return studentService.insert(student);
    }

    @ApiOperation("修改学生信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody  Student student){
        return studentService.update(student);
    }

    @ApiOperation("修改学生信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody  Student student){
        return studentService.updateShow(student);
    }

    @ApiOperation("删除学生信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody  Student student){
        return studentService.delete(student);
    }
}
