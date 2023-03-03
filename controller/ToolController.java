package com.server.controller;

import com.server.service.MallpersonnelService;
import com.server.utils.MD5Utils;
import com.server.utils.MailUtil;
import com.server.utils.QiniuUtils;
import com.server.utils.Result;
import com.server.vo.MailVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Random;

/**
 * @author ： 
 * @date ：Created in  2022/11/13 0:52
 * @description：工具控制器
 * @modified By：
 */
@RestController
@RequestMapping("/tool")
public class ToolController {
    @Autowired
    private QiniuUtils qiniuUtils;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private MallpersonnelService mallpersonnelService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ApiOperation(value ="七牛云文件上传" )
    @PostMapping("/upload")
    public Result upload(@RequestBody MultipartFile file) throws IOException{

      String url =  qiniuUtils.upload(file.getInputStream(),file.getOriginalFilename());
      return Result.success("文件上传成功",url);
    }
    @ApiOperation(value ="忘记密码？邮件找回" )
    @PostMapping("/forget/password")
    public Result forget(@RequestBody MailVo mailVo){
        mailVo.setSubject("净水设备销售商城管理平台");
        //随机数
        Random random = new Random();
        int password= 100000+random.nextInt(1000000);
        mallpersonnelService.updatePwdByMail(mailVo.getReceivers()[0],passwordEncoder.encode( MD5Utils.md5(String.valueOf(password))));
        mailVo.setContent("你的新密码："+ password +"，请妥善保管！");
        return  Result.success(mailUtil.sendMail(mailVo));
    }
}
