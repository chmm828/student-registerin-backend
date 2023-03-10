package com.server.config.security.handler;

import com.server.utils.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ： 
 * @date ：Created in  2022/10/25 1:02
 * @description：没有权限访问时，返回结果
 * @modified By：
 */

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setStatus(403);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer =response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(Result.fail("权限不足，请联系管理员")));
        writer.flush();
        writer.close();
    }
}
