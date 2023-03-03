package com.server.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ： 
 * @date ：Created in  2022/11/7 1:58
 * @description：redis的工具类
 * @modified By：
 */
@Component
@Slf4j
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 向redis中存值
     * @param key 键
     * @param value 值
     * @return 是否传入成功
     */
    public boolean setValue(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            log.error("向redis中存入值时异常--》{}",e.getMessage());
            return  false;
        }
    }

    /**
     * 向redis存值并指定过期时间
     * SECONDS为秒
     * MINUTES为分
     * hours为时间
     * days： 天
     * @param key 键
     * @param value 值
     * @param time 时间
     * @return 是否传入成功
     */
    public  boolean setValueTime(String key,Object value,long time){
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key,value,time, TimeUnit.MINUTES);
            }else {
                redisTemplate.opsForValue().set(key,value);
            }
            return  true;
        }catch (Exception e){
            log.error("设置缓存并指定过期时间异常-->{}",e.getMessage());
            return  false;
        }
    }

    /**
     * 根据key获取redis中的值
     * @param key
     * @return
     */
    public Object getValue(String key){
        return key==null ? null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据key删除redis中的缓存
     * @param keys 多个key
     * @return
     */
    public void delKey(String... keys){
        if(keys!=null && keys.length>0) {
            if (keys.length == 1) {
                redisTemplate.delete(keys[0]);
            } else {
               for (String key: keys){
                   redisTemplate.delete(key);
               }
            }
        }
    }

    /**
     *判断值是否存在
     * @param key
     * @return
     */
    public  boolean hasKey(String key){
        try {

            return  redisTemplate.hasKey(key);
        }catch (Exception e){
            log.error("redis不存在");
            return false;
        }
    }

    /**
     * 获取redis键的过期时间
     * 0代表永久有效
     * 大于0就是剩余多少分钟失效
     * @param key
     * @return
     */
    public Long isExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.MINUTES);
    }

    /**
     * 给这个key设置过期时间，热点数据刷新，防止缓存击穿。访问一次刷新一次过期时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key,long time){
        try{
            if(time>0){
                redisTemplate.expire(key,time,TimeUnit.MINUTES);
            }
            return  true;
        }catch (Exception e){
            log.error("给旧的缓存设置新的时间异常-->{}",e.getMessage());
            return false;
     }
    }
}
