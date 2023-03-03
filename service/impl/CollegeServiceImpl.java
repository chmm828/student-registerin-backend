package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.College;
import com.server.mapper.CollegeMapper;
import com.server.service.CollegeService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        log.info("开始权限数据分页-->页码{}，-->页数{},-->查询内容{}",queryInfo.getPageNumber(),queryInfo.getPageSize(),queryInfo.getQueryString());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<College> page = collegeMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<College> result = page.getResult();
        log.info("查询的总条数-->{}",total);
        log.info("分页列表-->{}",result);
        return new PageResult(total,result);
    }

    @Override
    public Result insert(College college) {
        collegeMapper.insert(college);
        return  Result.success("添加学院数据成功");
    }

    @Override
    public Result delete(College college) {
        collegeMapper.delete(college);
        return  Result.success("删除学院数据成功");
    }

    @Override
    public Result update(College college) {
        collegeMapper.update(college);
        return Result.success("修改学院数据成功");
    }

    @Override
    public Result updateShow(College college) {
        collegeMapper.updateShow(college);
        return Result.success("修改学院数据成功");
    }

    @Override
    public Result findCollegeInfo() {
        collegeMapper.findCollegeInfo();
        return Result.success("查找所有学院信息成功",collegeMapper.findCollegeInfo());
    }
}
