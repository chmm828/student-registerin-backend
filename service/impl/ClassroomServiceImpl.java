package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.Canteen;
import com.server.entity.Classroom;
import com.server.mapper.CanteenMapper;
import com.server.mapper.ClassroomMapper;
import com.server.service.ClassroomService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomMapper classroomMapper;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        log.info("开始权限数据分页-->页码{}，-->页数{},-->查询内容{}",queryInfo.getPageNumber(),queryInfo.getPageSize(),queryInfo.getQueryString());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Classroom> page = classroomMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Classroom> result = page.getResult();
        log.info("查询的总条数-->{}",total);
        log.info("分页列表-->{}",result);
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Classroom classroom) {
        classroomMapper.insert(classroom);
        return  Result.success("添加教室数据成功");
    }

    @Override
    public Result delete(Classroom classroom) {
        classroomMapper.delete(classroom);
        return  Result.success("删除教室数据成功");
    }

    @Override
    public Result update(Classroom classroom) {
        classroomMapper.update(classroom);
        return Result.success("修改教室数据成功");
    }

    @Override
    public Result updateShow(Classroom classroom) {
        classroomMapper.updateShow(classroom);
        return Result.success("修改教室数据成功");
    }

    @Override
    public Result findClassroomInfo() {
        return Result.success(" 查找教室数据成功",  classroomMapper.findClassroomInfo());
    }
}
