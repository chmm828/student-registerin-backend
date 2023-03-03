package com.server.controller;

import com.server.entity.Major;
import com.server.service.MajorService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/major")
    @Api(tags = "专业信息管理接口")
    public class MajorController {
        @Autowired
        MajorService majorService;

        @ApiOperation("分页获取专业信息接口")
        @PostMapping("/findPage")
        //@RequestBody:前端传来的json数据转换成对象
        public Result findPage(@RequestBody QueryInfo queryInfo){
            return majorService.findPage(queryInfo);
        }

        @ApiOperation("添加专业信息接口")
        @PostMapping("/insert")
        public Result insert(@RequestBody Major major){
            return majorService.insert(major);
        }

        @ApiOperation("修改专业信息接口")
        @PutMapping("/update")
        public Result update(@RequestBody Major major){
            return majorService.update(major);
        }

        @ApiOperation("修改专业信息是否展示接口")
        @PutMapping("/updateShow")
        public Result updateShow(@RequestBody Major major){
            return majorService.updateShow(major);
        }

        @ApiOperation("删除专业信息接口")
        @PutMapping("/delete")
        public Result delete(@RequestBody Major major){
            return majorService.delete(major);
        }

        @ApiOperation("查询专业信息接口，用于后台")
        @GetMapping("/findMajorInfo")
        public Result findMajorInfo(){
            return majorService.findMajorInfo();
        }
}
