package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.Counselor;
import com.server.mapper.CounselorMapper;
import com.server.service.CounselorService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CounselorServiceImpl implements CounselorService {
    @Autowired
    CounselorMapper CounselorMapper;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Counselor> page = CounselorMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Counselor> result = page.getResult();
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Counselor counselor) {
        CounselorMapper.insert(counselor);
        return  Result.success("添加辅导员数据成功");
    }

    @Override
    public Result delete(Counselor counselor) {
        CounselorMapper.delete(counselor);
        return  Result.success("删除辅导员数据成功");
    }

    @Override
    public Result update(Counselor counselor) {
        CounselorMapper.update(counselor);
        return Result.success("修改辅导员数据成功");
    }

    @Override
    public Result updateShow(Counselor counselor) {
        CounselorMapper.updateShow(counselor);
        return Result.success("修改辅导员数据成功");
    }

    @Override
    public Result findCounselorInfo() {
        return Result.success("查询辅导员数据成功", CounselorMapper.findCounselorInfo());
    }
}
