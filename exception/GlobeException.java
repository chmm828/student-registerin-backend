package com.server.exception;

import com.server.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * @author ： 
 * @date ：Created in  2022/10/29 20:31
 * @description：全局异常处理
 * @modified By：
 */
@Slf4j
@RestControllerAdvice
public class GlobeException {


    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public Result exception(AccessDeniedException e){
        log.error("权限不足----------》{}",e.getMessage());
        return  Result.fail("权限不足，请联系管理员！");
    }

//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler()
//    public Result exception(RuntimeException e){
//        e.printStackTrace();
//        log.error("系统运行时异常----------》{}",e.getMessage());
//        return Result.fail(e.getMessage());
//    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = UsernameNotFoundException.class)
    public Result exception(UsernameNotFoundException e){
        log.error("用户名没有找到----》{}",e.getMessage());
        return  Result.fail(e.getMessage());
    }
}
