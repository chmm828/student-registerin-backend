package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.ClassEntity;
import com.server.mapper.ClassMapper;
import com.server.service.ClassService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<ClassEntity> page = classMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<ClassEntity> result = page.getResult();
        return new PageResult(total,result);
    }

    @Override
    public Result insert(ClassEntity classEntity) {
        classMapper.insert(classEntity);
        return  Result.success("添加学院数据成功");
    }

    @Override
    public Result delete(ClassEntity classEntity) {
        classMapper.delete(classEntity);
        return  Result.success("删除学院数据成功");
    }

    @Override
    public Result update(ClassEntity classEntity) {
        classMapper.update(classEntity);
        return Result.success("修改学院数据成功");
    }

    @Override
    public Result updateShow(ClassEntity classEntity) {
        classMapper.updateShow(classEntity);
        return Result.success("修改学院数据成功");
    }

    @Override
    public Result findClassInfo() {
        return Result.success("查询班级信息成功",classMapper.findClassInfo());
    }
}
