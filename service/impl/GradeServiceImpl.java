package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.Grade;
import com.server.mapper.GradeMapper;
import com.server.service.GradeService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    GradeMapper gradeMapper;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Grade> page = gradeMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Grade> result = page.getResult();
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Grade grade) {
        gradeMapper.insert(grade);
        return  Result.success("添加年级数据成功");
    }

    @Override
    public Result delete(Grade grade) {
        gradeMapper.delete(grade);
        return  Result.success("删除年级数据成功");
    }

    @Override
    public Result update(Grade grade) {
        gradeMapper.update(grade);
        return Result.success("修改年级数据成功");
    }

    @Override
    public Result updateShow(Grade grade) {
        gradeMapper.updateShow(grade);
        return Result.success("修改年级数据成功");
    }

    @Override
    public Result findGradeInfo() {
        return Result.success("查询年级信息成功",gradeMapper.findGradeInfo());
    }
}
