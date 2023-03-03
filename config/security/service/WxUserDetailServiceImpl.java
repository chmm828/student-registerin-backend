package com.server.config.security.service;

import com.server.entity.Mallpersonnel;
import com.server.entity.Student;
import com.server.entity.SysMenu;
import com.server.mapper.MallpersonnelMapper;
import com.server.mapper.StudentMapper;
import com.server.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class WxUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //判断缓存中是否存在用户信息，存在则直接从缓存中取，不存在则查数据库并把数据存入缓存
        Student user;
        user = studentMapper.findByUserName(username);
//        if(redisUtil.hasKey("userInfo_"+username)){
//            //缓存中存在用户信息，直接从redis中取
//            //将obeject类型强转换
//            user = (Student) redisUtil.getValue("userInfo_"+username);
//            //每次都拿到5分钟的缓存，直到不使用时，才过期
//            redisUtil.expire("userInfo_"+username,5);
//        }else {
//            //不存在缓存，则查数据库并把数据存入缓存
            //1在mapper自定义登录，根据用户名获取用户信息
            user = studentMapper.findByUserName(username);
//            if(user==null){
//                throw  new  UsernameNotFoundException(("用户名或密码错误"));
//            }
//            redisUtil.setValueTime("userInfo_"+username,user,5);
//        }
        return  user;
    }
}

