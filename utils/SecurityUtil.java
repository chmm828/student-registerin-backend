package com.server.utils;

import com.server.entity.Mallpersonnel;
import com.server.entity.Student;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ： 
 * @date ：Created in  2022/10/31 14:55
 * @description：用于获取用户基本信息
 * @modified By：
 */
public class SecurityUtil {
    /**
     * 从Security主体信息中获取用户信息
     * @return
     */
    public  static Mallpersonnel getUser(){
    Mallpersonnel user=(Mallpersonnel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //给前端返回空密码null
    user.setPassword(null);
    return  user;
    }

    /**
     * 从Security主体信息中获取学生信息
     * @return
     */

    public  static Student getStudent(){
        Student student=(Student) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //给前端返回空密码null
        student.setStudentPassword(null);
        return  student;
    }

    /**
     * 在security中获取用户名
     * @return
     */
    public  static String getUsername(){
        return getUser().getUsername();
    }

    /**
     * 在security中获取用户ID
     * @return
     */
    public static Integer getUserId(){
        return getUser().getPId();
    }
}
