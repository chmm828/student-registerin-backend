package com.server.controller;

import com.server.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController==@controller+@ResponseBody
 * @program: java-jssb
 * @description: 测试
 * @author:  
 * @create: 2021-10-23 10:06
 **/
@RestController
@Api(value = "测试接口")
public class TestController {
    @ApiOperation(value = "测试test")
    @GetMapping("/test")
    public Result test(){
        return Result.success("返回成功","你好");
    }
}
