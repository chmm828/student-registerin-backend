package com.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.server.mapper")
@SpringBootApplication
public class JavaJssbApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaJssbApplication.class, args);
    }

}
