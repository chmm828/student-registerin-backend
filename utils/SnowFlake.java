package com.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ： 
 * @date ：Created in  2022/11/25 15:36
 * @description： 订单算法
 * @modified By：
 */
public class SnowFlake {
    public  String getCid(int b) {
        //获取当前时间
        String dateString = getDate(new Date(), "yyyyMMdd");
        String a = String.format("%03d", b);
        String cid = "jssb" + dateString + a;
        //注意点,你可以将b这个值设置到缓存当中或者数据库当中,然后每次那这个值就可以
        return cid;
    }

    public static String getDate(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdFormat = new SimpleDateFormat(format);

        return sdFormat.format(date);
    }

//    public static void main(String[] args) {
//        String cid = getCid(3);
//        System.out.println("获取的id:"+cid);
//
//    }
}
