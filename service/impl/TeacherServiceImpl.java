package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.Teacher;
import com.server.mapper.StudentMapper;
import com.server.mapper.TeacherMapper;
import com.server.service.TeacherService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Teacher> page = teacherMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Teacher> result = page.getResult();
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Teacher teacher) {
        teacherMapper.insert(teacher);
        return  Result.success("添加老师数据成功");
    }

    @Override
    public Result delete(Teacher teacher) {
        teacherMapper.delete(teacher);
        return  Result.success("删除老师数据成功");
    }

    @Override
    public Result update(Teacher teacher) {
        teacherMapper.update(teacher);
        return Result.success("修改老师数据成功");
    }

    @Override
    public Result updateShow(Teacher teacher) {
        teacherMapper.updateShow(teacher);
        return Result.success("修改老师数据成功");
    }

    @Override
    public Result findTeacherInfo() {
        return Result.success("查询老师信息成功",teacherMapper.findTeacherInfo());
    }
}
