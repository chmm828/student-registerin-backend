package com.server.controller;

import com.server.entity.Library;
import com.server.service.LibraryService;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: 新生报道系统
 *
 * @description: 图书馆信息的增删改查
 *
 * @author: 11
 *
 **/
@RestController
@RequestMapping("/library")
@Api(tags = "图书馆信息管理接口")
public class LibraryController {
    @Autowired
    LibraryService libraryService;

    @ApiOperation("分页获取图书馆信息接口")
    @PostMapping("/findPage")
    //@RequestBody:前端传来的json数据转换成对象
    public Result findPage(@RequestBody QueryInfo queryInfo){
        return libraryService.findPage(queryInfo);
    }

    @ApiOperation("添加图书馆信息接口")
    @PostMapping("/insert")
    public Result insert(@RequestBody Library library){
        return libraryService.insert(library);
    }

    @ApiOperation("修改图书馆信息接口")
    @PutMapping("/update")
    public Result update(@RequestBody  Library library){
        return libraryService.update(library);
    }

    @ApiOperation("修改图书馆信息是否展示接口")
    @PutMapping("/updateShow")
    public Result updateShow(@RequestBody  Library library){
        return libraryService.updateShow(library);
    }

    @ApiOperation("删除图书馆信息接口")
    @PutMapping("/delete")
    public Result delete(@RequestBody  Library library){
        return libraryService.delete(library);
    }

    @ApiOperation("查找图书馆信息")
    @GetMapping("/getLibraryInfo")
    public Result getLibraryInfo() {
        return libraryService.findLibraryInfo();
    }
}
