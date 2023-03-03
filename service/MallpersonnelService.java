package com.server.service;

import com.server.entity.Mallpersonnel;
import com.server.utils.QueryInfo;
import com.server.utils.Result;
import com.server.vo.LoginVo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: java-jssb
 * @description: 用户操作逻辑的接口
 * @author:  
 * @create: 2021-10-24 00:40
 **/
public interface MallpersonnelService {
    /**
     * 登录接口
     * @param loginVo 登录参数 账号和密码
     * @return 返回Token，用token去获取资源
     */
     Result login(@RequestBody LoginVo loginVo);

    /**
     * 根据用户名获取用户信息
     * @param
     * @return
     */
     Mallpersonnel findByUsername(String username);

    /**
     * 分页查询
     * @param queryInfo
     * @return
     */
     Result findPage(QueryInfo queryInfo);

    /**
     * 添加用户信息
     * @param mallpersonnel
     * @return
     */
     Result insert(Mallpersonnel mallpersonnel);

    /**
     * 修改用户信息
     * @param mallpersonnel
     * @return
     */
     Result update(Mallpersonnel mallpersonnel);

    /**
     * 删除用户信息
     * @param pId
     * @return
     */
     Result delete(Integer pId);

    /**
     * 根据邮件箱 修改密码
     * @param email
     * @param password
     */
    void updatePwdByMail(String email, String password);

    /**
     *  查找管理员信息
     */
    Result findAdmin();
    
}
