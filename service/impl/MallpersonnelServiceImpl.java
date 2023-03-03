package com.server.service.impl;



import com.server.config.security.service.UserDetailServiceImp;
import com.server.entity.Mallpersonnel;
import com.server.entity.SysRole;
import com.server.mapper.MallpersonnelMapper;
import com.server.service.MallpersonnelService;
import com.server.utils.*;
import com.server.vo.LoginVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: java-jssb
 * @description:
 * @author:  
 * @create: 2021-10-24 00:46
 **/
@Service
@Slf4j
public class MallpersonnelServiceImpl implements MallpersonnelService {
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private MallpersonnelMapper mallpersonnelMapper;
    @Autowired
    private UserDetailServiceImp userDetailServiceImp;


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     *登录接口
     * @param loginVo 登录参数 账号和密码
     * @return
     */
    @Override
    public Result login(LoginVo loginVo) {
        log.info("1.开始登录");
        UserDetails userDetails = userDetailServiceImp.loadUserByUsername(loginVo.getUsername());
        log.info("2.判断用户是否存在，密码是否正确");
        if (userDetails==null || !passwordEncoder.matches(MD5Utils.md5(loginVo.getPassword()),userDetails.getPassword())){
            return Result.fail("账号或者密码错误,请重新输入！");
        }
        if(!userDetails.isEnabled()){
            return Result.fail("账号被禁止使用，请联系管理员！");
        }
        log.info("3.登录成功，在security对象中存入登录者信息");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        log.info("4.根据登录信息获取token");
        String token =tokenUtil.generateToken(userDetails);
        //给前端返回数据
        Map<String,String>  map =new HashMap<>(2);
        map.put("tokenHead",tokenHead);
        map.put("token",token);
        return Result.success("登录成功",map);
    }

    @Override
    public Mallpersonnel findByUsername(String username) {
        return mallpersonnelMapper.findByUsername(username);
    }

    @Override
    public Result findPage(QueryInfo queryInfo) {
        log.info("开始用户信息分页-->页码{}，-->页数大小{}",queryInfo.getPageNumber(),queryInfo.getPageSize());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Mallpersonnel> page = mallpersonnelMapper.findPage(queryInfo.getQueryString());
        long total = page.getTotal();
        List<Mallpersonnel> result = page.getResult();
        result.forEach(item-> {
            item.setRoles(mallpersonnelMapper.findRoles(item.getPId()));
            item.setPName(item.getUsername());
            item.setPassword(null);
        });
        return PageResult.pageResult(total,result);
    }

    @Transactional
    @Override
    public Result insert(Mallpersonnel mallpersonnel) {


        log.info("根据用户名查询用户信息");
        Mallpersonnel personnel = mallpersonnelMapper.findByUsername(mallpersonnel.getUsername());
        if (personnel !=null) {
            return Result.fail("用户名已经存在");
        }
        log.info("给密码加密");

        mallpersonnel.setPassword(passwordEncoder.encode(MD5Utils.md5(mallpersonnel.getPassword())));
        log.info("1.添加用户信息");
        //存取本地时间
        DateDome dateDome =new DateDome();
        mallpersonnel.setCreateTime(dateDome.getNewDateTime());
        mallpersonnel.setUpdateTime(dateDome.getNewDateTime());
        mallpersonnelMapper.insert(mallpersonnel);
        log.info("2.添加角色信息");
        List<SysRole> roles = mallpersonnel.getRoles();
        if (roles.size()>0){
            roles.forEach(item->{
                mallpersonnelMapper.insertUserRoles(mallpersonnel.getPId(),item.getId());
            });
        }

        log.info("3.用户的角色有{}个",roles.size());
        return Result.success("用户添加成功");
    }

    @Transactional
    @Override
    public Result update(Mallpersonnel mallpersonnel) {


        log.info("1.先将用户角色信息删除");
        mallpersonnelMapper.deleteByUserId(mallpersonnel.getPId());
        log.info("2.添加用户角色信息");
        List<SysRole> roles = mallpersonnel.getRoles();
        if(roles.size()>0){
            roles.forEach(item ->{
                mallpersonnelMapper.insertUserRoles(mallpersonnel.getPId(),item.getId());
            });
        }
//        md5加密不好修改,不要了
//        log.info("给密码加密");
//        mallpersonnel.setPassword(passwordEncoder.encode(MD5Utils.md5(mallpersonnel.getPassword())));
        log.info("3.修改用户信息");
        //存取本地时间
        DateDome dateDome =new DateDome();
        mallpersonnel.setCreateTime(dateDome.getNewDateTime());
        mallpersonnel.setUpdateTime(dateDome.getNewDateTime());
        mallpersonnelMapper.update(mallpersonnel);
        return Result.success("用户信息修改成功！");
    }

    @Override
    public Result delete(Integer pId) {
        Mallpersonnel mallpersonnel = mallpersonnelMapper.findBypId(pId);
        if (mallpersonnel==null) {
            return Result.fail("用户ID不存在");
        }
        mallpersonnelMapper.deleteRolesByUserId(pId);
        mallpersonnelMapper.delete(pId);
        return Result.success("用户信息删除成功！");
    }

    @Override
    public void updatePwdByMail(String email, String password) {
        log.info("修改密码");
        mallpersonnelMapper.updatePwdByMail(email,password);
    }

    @Override
    public Result findAdmin() {
        List<Mallpersonnel> mallpersonnels = mallpersonnelMapper.findAdminInfo();
        mallpersonnels.forEach(item-> {
            item.setPName(item.getUsername());
            item.setPassword(null);
        });
        return Result.success("查找管理员信息成功",mallpersonnels);
    }
}
