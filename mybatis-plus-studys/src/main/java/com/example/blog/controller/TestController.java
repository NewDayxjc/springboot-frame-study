package com.example.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2021/7/11 14:15
 * <p>
 * TestController
 */
@RestController
@RequestMapping("/info")
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "Hello Everything";
    }
}
