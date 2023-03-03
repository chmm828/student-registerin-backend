package com.server.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ： 
 * mD5是单项加密 不可逆==>不能解密
 *
 * @date ：Created in  2022/11/12 18:35
 * @description：MD5加密法
 * @modified By：
 */
@Slf4j
public class MD5Utils {
    /**
     * md5加密
     * @param password 要加密内容
     * @return 32位的加密算法
     */
    public  static  String md5(String password){
        if (StringUtils.isNotEmpty(password)) {
            byte[] bytes =null;
            try {
                bytes = MessageDigest.getInstance("md5").digest(password.getBytes());
            }catch (NoSuchAlgorithmException e){
                log.error("没有md5加密算法");
            }
            //由MD5加密算法得到的字节数组转换位16进制数字
           StringBuilder code = new StringBuilder(new BigInteger(1,bytes).toString(16));
            //保证MD5j加密时32位
            for (int i = 0; i < 32 - code.length(); i++) {
              code.insert(0,"0");
            }
            return  code.toString();
        }else{
            return  null;
        }
    }

    public static void main(String[] args) {
        System.out.println(md5("123456"));
    }
}
