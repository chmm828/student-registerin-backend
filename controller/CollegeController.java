package com.server.controller;

import com.server.entity.College;
import com.server.service.CollegeService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 学院信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/college")
@Api(tags = "学院信息管理接口")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @ApiOperation("分页获取学院信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return collegeService.findPage(queryInfo);
    }

    @ApiOperation("添加学院信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody College college){
        return collegeService.insert(college);
    }

    @ApiOperation("修改学院信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody College college){
        return collegeService.update(college);
    }

    @ApiOperation("修改学院信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody College college){
        return collegeService.updateShow(college);
    }

    @ApiOperation("删除学院信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody College college){
        return collegeService.delete(college);
    }

    @ApiOperation("查询学院信息接口")
    @GetMapping("/findCollegeInfo")
    public Result findCollegeInfo(){
        return collegeService.findCollegeInfo();
    }
}
