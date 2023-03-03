package com.server.config.security;

import com.server.config.security.contents.SecurityContents;
import com.server.config.security.handler.JwtAccessDeniedHandler;
import com.server.config.security.handler.JwtAuthenticationEntryPoint;
import com.server.config.security.handler.JwtAuthenticationFilter;
import com.server.config.security.service.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author ： 
 * @date ：Created in  2022/10/24 19:38
 * @description：权限基本配置
 * @modified By：
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImp userDetailServiceImp;
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * 用来配置白名单
     * 白名单：可以没有权限也可以访问到资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers(SecurityContents.WHITE_LIST);
    }

    /**
     * Security的核心配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       //1、使用jwt，首先关闭跨域攻击
        http.csrf().disable();
        //2.关闭session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //3.请求都需要进认证。认证之后才能访问。除白名单以外的资源
        http.authorizeRequests().anyRequest().authenticated();
        //关闭缓存
        http.headers().cacheControl();
        //5.token过滤器，校验token
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        //6.没有登录。没有权限访问资源自定义返回结果
        http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).accessDeniedHandler(jwtAccessDeniedHandler);

    }

    /**
     * 自定义逻辑的配置
     * 也就是配置到security中进行认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailServiceImp).passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }
}
