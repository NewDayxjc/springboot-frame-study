package com.example.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2021/6/23 7:30
 * 入口类
 * SpringBootApplication
 */
@SpringBootApplication
@MapperScan(basePackages = "com.example.blog.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
