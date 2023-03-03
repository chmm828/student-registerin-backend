package com.server.controller;/**
 * @author :  
 * @date : 18:28  2022/10/23
 */

import com.server.service.MallpersonnelService;
import com.server.utils.RedisUtil;
import com.server.utils.Result;
import com.server.utils.SecurityUtil;
import com.server.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @program: java-jssb    
 *
 * @description: 登录及退出，获取当前登录用户的基本信息的相关接口
 *
 * @author:  
 *
 * @create: 2021-10-23 18:28
 **/
@RestController
@RequestMapping("/user")
@Api(value = "用户使用接口")
public class LoginController {
    //调用用户信息
    @Autowired
    private MallpersonnelService mallpersonnelService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation("登录接口")
    @PostMapping("/login")
    public Result login(@RequestBody LoginVo loginVo){
        return mallpersonnelService.login(loginVo);
    }

    @ApiOperation(value = "获取用户基本信息")
    @GetMapping("/getInfo")
    public Result getUserInfo(){
        return  Result.success("获取用户信息成功", SecurityUtil.getUser());
    }

    @ApiOperation(value = "用户退出登录")
    @GetMapping("/logout")
    public Result logout(){
        //退出时，清楚缓存
        redisUtil.delKey("userInfo_"+SecurityUtil.getUsername());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null){
           SecurityContextHolder.getContext().setAuthentication(null);
        }
        return Result.success("退出成功");
    }
}
