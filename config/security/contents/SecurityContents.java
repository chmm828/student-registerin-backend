package com.server.config.security.contents;

/**
 * @author ： 
 * @date ：Created in  2022/10/31 10:12
 * @description：白名单
 * @modified By：
 */
public class SecurityContents {
    public static final String[] WHITE_LIST ={
            //后端的登录接口
            "/user/login",
            "/Wx/login",

            // 小程序
            "student/getStudentInfo/**",

            // 七牛云
            "/tool/upload",
            //swagger相关
            "/favicon.ico",
            "/swagger-ui.html",
            "/doc.html",
            "/webjars/**",
            "/swagger-resources/**",
            "/v2/**",
            "/configuration/ui",
            "/configuration/security",

            //放行密码找回
            "/tool/forget/password",
            "/test",

            //学生
            "/student/**",

            //学院
            "/college/findCollegeInfo",

            //图书馆
            "/library/getLibraryInfo",

            //教室
            "/classroom/findClassroomInfo",

            // 食堂
            "/canteen/findCanteenInfo"

    };
}
