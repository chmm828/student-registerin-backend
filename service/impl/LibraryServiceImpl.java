package com.server.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.server.entity.Library;
import com.server.entity.Mallpersonnel;
import com.server.mapper.LibraryMapper;
import com.server.service.LibraryService;
import com.server.utils.PageResult;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LibraryServiceImpl  implements LibraryService {
    @Autowired
    LibraryMapper libraryMapper;

    @Override
    public Result findPage(QueryInfo queryInfo) {
        log.info("开始权限数据分页-->页码{}，-->页数{},-->查询内容{}",queryInfo.getPageNumber(),queryInfo.getPageSize(),queryInfo.getQueryString());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Library> page = libraryMapper.findPage(queryInfo.getQueryString());
        long total =page.getTotal();
        List<Library> result = page.getResult();
        log.info("查询的总条数-->{}",total);
        log.info("分页列表-->{}",result);
        return new PageResult(total,result);
    }

    @Override
    public Result insert(Library library) {
        libraryMapper.insert(library);
        return  Result.success("添加图书馆数据成功");
    }

    @Override
    public Result delete(Library library) {
        libraryMapper.delete(library);
        return  Result.success("删除图书馆数据成功");
    }

    @Override
    public Result update(Library library) {
        libraryMapper.update(library);
        return Result.success("修改图书馆数据成功");
    }

    @Override
    public Result updateShow(Library library) {
        libraryMapper.updateShow(library);
        return Result.success("修改图书馆数据成功");
    }

    @Override
    public Result findLibraryInfo() {
        List<Library> libraries = libraryMapper.findLibraryInfo();
////        List<String> list = Arrays.asList(1, 2, 3, 4, 5);
//        String[] array = new String[libraries.size()];
//
////        for (Library item : libraries) {
////            array[i++] = item;
////        }
//
//        Map<String,String> map =new HashMap<>(2);
//        libraries.forEach(item-> {
//            int i = 0;
//            array[i++] = item.getLibraryImg();
//
//        });

        return Result.success("查找图书馆数据成功",libraries);
    }
}
