package com.server.config.security.service;

import com.server.entity.Mallpersonnel;
import com.server.entity.SysMenu;
import com.server.mapper.MallpersonnelMapper;
import com.server.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：
 * @date ：Created in  2022/10/27 8:40
 * @description：实现用户接口，实现自定义登录逻辑、从写UserByUsername方法
 * @modified By：
 */
@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    private MallpersonnelMapper mallpersonnelMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //判断缓存中是否存在用户信息，存在则直接从缓存中取，不存在则查数据库并把数据存入缓存
        Mallpersonnel user;
        if(redisUtil.hasKey("userInfo_"+username)){
            //缓存中存在用户信息，直接从redis中取
            //将obeject类型强转换
            user = (Mallpersonnel)redisUtil.getValue("userInfo_"+username);
            //每次都拿到5分钟的缓存，直到不使用时，才过期
            redisUtil.expire("userInfo_"+username,5);
        }else {
            //不存在缓存，则查数据库并把数据存入缓存
            //1在mapper自定义登录，根据用户名获取用户信息
            user = mallpersonnelMapper.findByUsername(username);
            if(user==null){
                throw  new  UsernameNotFoundException(("用户名或密码错误"));
            }
            if(user.isAdmin()){
                //非管理员需要查询角色信息
                user.setRoles(mallpersonnelMapper.findRoles(null));
                user.setPermissions(mallpersonnelMapper.findPermissions(null));
                //获取父级菜单
                List<SysMenu> menus =mallpersonnelMapper.findMenus(null);
                //获取子集菜单
                menus.forEach(item -> item.setChildren(mallpersonnelMapper.findChildrenMenu(item.getId(),null)));
                user.setMenus(menus);
            }else{
                //非管理员需要查询角色信息
                user.setRoles(mallpersonnelMapper.findRoles(user.getPId()));
                user.setPermissions(mallpersonnelMapper.findPermissions(user.getPId()));
                //获取父级菜单
                List<SysMenu> menus =mallpersonnelMapper.findMenus(user.getPId());
                //获取子集菜单
                menus.forEach(item -> item.setChildren(mallpersonnelMapper.findChildrenMenu(item.getId(),user.getPId())));
                user.setMenus(menus);
            }
//            //不给前端查到看密码
//            user.setPassword(null);
            redisUtil.setValueTime("userInfo_"+username,user,5);
        }
      return  user;
    }
}
