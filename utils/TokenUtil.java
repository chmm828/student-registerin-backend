package com.server.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ： 
 * @date ：Created in  2022/10/24 18:04
 * @description：token工具类，用于生成token
 * 用户拿到token 然后访问我们的系统资源
 * @modified By：
 */
@Component
public class TokenUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private  long expiration;

    /**
     * 传入用户信息，生成token
     * @param userDetails
     * @return
     */
    public  String generateToken(UserDetails userDetails){
       Map<String,Object>map= new HashMap<>(2);
       map.put("pName",userDetails.getUsername());
       map.put("createTime",new Date());
       return this.genrateJwt(map);
    }

    /**
     * 根据荷载信息去生成token
     * @param map
     * @return
     */
    public String genrateJwt(Map<String,Object>map){
      return   Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS512,secret)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .compact();
    }

    /**
     * 根据token获取荷载信息
     * @param token
     * @return
     */
    public Claims getTokenBody(String token){
        try {
            return  Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            return  null;
        }
    }

    /**
     * 根据Token得到用户名
     * @param token
     * @return
     */
    public String getUsernameByToken(String token){
        return (String) this.getTokenBody(token).get("pName");
    }

    /**
     * 根据token判断该时间内，token是否过期
     * @param token
     * @return
     */
    public  boolean isExpiration(String token){
        return this.getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 刷新token，令牌
     * @param token
     * @return
     */

    public String refreshToken(String token){
        Claims claims =this.getTokenBody(token);
        claims.setExpiration(new Date());
        return this.genrateJwt(claims);
    }

}
