package com.server.controller;

import com.server.entity.Counselor;
import com.server.service.CounselorService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 辅导员信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/counselor")
@Api(tags = "辅导员信息管理接口")
public class CounselorController {
        @Autowired
        CounselorService counselorService;

        @ApiOperation("分页获取辅导员信息接口")
        @PostMapping("/findPage")
        //@RequestBody:前端传来的json数据转换成对象
        public Result findPage(@RequestBody QueryInfo queryInfo) {
            return counselorService.findPage(queryInfo);
        }

        @ApiOperation("添加辅导员信息接口")
        @PostMapping("/insert")
        public Result insert(@RequestBody Counselor counselor) {
            return counselorService.insert(counselor);
        }

        @ApiOperation("修改辅导员信息接口")
        @PutMapping("/update")
        public Result update(@RequestBody Counselor counselor) {
            return counselorService.update(counselor);
        }

        @ApiOperation("修改辅导员信息是否展示接口")
        @PutMapping("/updateShow")
        public Result updateShow(@RequestBody Counselor counselor) {
            return counselorService.updateShow(counselor);
        }

        @ApiOperation("删除辅导员信息接口")
        @PutMapping("/delete")
        public Result delete(@RequestBody Counselor counselor) {
            return counselorService.delete(counselor);
        }

        @ApiOperation("查询辅导员信息接口")
        @GetMapping ("/findCounselorInfo")
        public Result findCounselorInfo() {
        return counselorService.findCounselorInfo();
    }
    }
