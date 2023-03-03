package com.server.utils;

/**
 * @author ： 
 * @date ：Created in  2022/11/12 18:40
 * @description：判断是否为空
 * @modified By：
 */
public class StringUtils {
    public static boolean isNotEmpty(String str){
        return  str!=null && !"".equals(str);
    }
}
