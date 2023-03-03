package com.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ： 
 * @date ：Created in  2022/11/9 18:20
 * @description：in
 * @modified By：
 */

public class DateDome {

       public String  getNewDateTime(){
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           return   sdf.format(new Date());
       }
}
