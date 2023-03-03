package com.server.config.security.handler;

import com.server.config.security.service.UserDetailServiceImp;
import com.server.config.security.service.WxUserDetailServiceImpl;
import com.server.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ： 
 * @date ：Created in  2022/10/25 1:11
 * @description：token认证.在接口访问进行认证
 * @modified By：
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private UserDetailServiceImp userDetailsService;

//    @Autowired
//    private WxUserDetailServiceImpl wxUserDetailService;

    @Value("${jwt.tokenHeader}")
    private String   tokenHeader;

    @Value("${jwt.tokenHead}")
    private String  tokenHead;

    /**
     * 请求头获取请求头信心token
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1.获取token
        String header = request.getHeader(tokenHeader);
        //2.判断token是否存在
        if (null != header && header.startsWith(tokenHead)) {
            //拿到token主体信息
            String token = header.substring(tokenHead.length());
            System.out.println(token);
            //根据token获取用户名
            String username = tokenUtil.getUsernameByToken(token);
            //3.token存在，但是没有登录信息
            if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
                //没有登录信息，直接登录
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                UserDetails student = wxUserDetailService.loadUserByUsername(username);

                //判断token是否有效
                if (!tokenUtil.isExpiration(token) && username.equals(userDetails.getUsername())) {
                    //刷新security中的用户信息
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }

//                //判断token是否有效
//                if (!tokenUtil.isExpiration(token) && username.equals(student.getUsername())) {
//                    //刷新security中的用户信息
//                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(student, null, student.getAuthorities());
//                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                }
            }
        }
        //过滤器放行
        filterChain.doFilter(request, response);
    }
}
