package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.Canteen;
import com.server.mapper.CanteenMapper;
import com.server.service.CanteenService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CanteenServiceImpl implements CanteenService {
    @Autowired
    CanteenMapper canteenMapper;
    
    @Override
    public Result findPage(QueryInfo queryInfo) {
        log.info("开始权限数据分页-->页码{}，-->页数{},-->查询内容{}",queryInfo.getPageNumber(),queryInfo.getPageSize(),queryInfo.getQueryString());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Canteen> page = canteenMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Canteen> result = page.getResult();
        log.info("查询的总条数-->{}",total);
        log.info("分页列表-->{}",result);
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Canteen canteen) {
        canteenMapper.insert(canteen);
        return  Result.success("添加食堂数据成功");
    }

    @Override
    public Result delete(Canteen canteen) {
        canteenMapper.delete(canteen);
        return  Result.success("删除食堂数据成功");
    }

    @Override
    public Result update(Canteen canteen) {
        canteenMapper.update(canteen);
        return Result.success("修改食堂数据成功");
    }

    @Override
    public Result updateShow(Canteen canteen) {
        canteenMapper.updateShow(canteen);
        return Result.success("修改食堂数据成功");
    }

    @Override
    public Result findCanteen() {
        return Result.success("查找食堂信息成功",canteenMapper.findCanteenInfo());
    }
}
