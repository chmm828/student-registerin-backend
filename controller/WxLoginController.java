package com.server.controller;

import com.server.service.StudentService;
import com.server.utils.Result;
import com.server.utils.SecurityUtil;
import com.server.vo.WxLoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ： 
 * @date ：Created in  2022/12/22 18:49
 * @description： 微信登录
 * @modified By：
 */
@RestController
@Api(tags = "   微信登录")
@RequestMapping("/Wx")
public class WxLoginController {

    @Autowired
    StudentService studentService;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody WxLoginVo wxLoginVo){
        return studentService.login(wxLoginVo);
    }
//
//    @ApiOperation(value = "获取微信openid")
//    @PostMapping("/login")
//    public Result findPage(@RequestBody Customer customer) {
//        String openId = WxUtils.wxOpenId(customer.getCode());
//        return Result.success("获取成功", openId);
//    }

    @ApiOperation(value = "获取用户基本信息")
    @GetMapping("/getInfo")
    public Result getUserInfo(){
        return  Result.success("获取用户信息成功",SecurityUtil.getStudent());
    }
}
