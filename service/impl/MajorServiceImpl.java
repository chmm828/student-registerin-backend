package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.Major;
import com.server.mapper.MajorMapper;
import com.server.service.MajorService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorMapper majorMapper;
    
    @Override
    public Result findPage(QueryInfo queryInfo) {
        log.info("开始权限数据分页-->页码{}，-->页数{},-->查询内容{}",queryInfo.getPageNumber(),queryInfo.getPageSize(),queryInfo.getQueryString());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Major> page = majorMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Major> result = page.getResult();
        log.info("查询的总条数-->{}",total);
        log.info("分页列表-->{}",result);
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Major major) {
        majorMapper.insert(major);
        return  Result.success("添加专业数据成功");
    }

    @Override
    public Result delete(Major major) {
        majorMapper.delete(major);
        return  Result.success("删除专业数据成功");
    }

    @Override
    public Result update(Major major) {
        majorMapper.update(major);
        return Result.success("修改专业数据成功");
    }

    @Override
    public Result updateShow(Major major) {
        majorMapper.updateShow(major);
        return Result.success("修改专业数据成功");
    }

    @Override
    public Result findMajorInfo() {
        return Result.success("查询专业信息成功",majorMapper.findMajorInfo());
    }
}
