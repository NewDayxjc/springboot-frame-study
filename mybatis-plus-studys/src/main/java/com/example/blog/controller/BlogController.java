package com.example.blog.controller;


import com.example.blog.entity.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiong
 * @since 2021-07-11
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private IBlogService blogService;

    @GetMapping("/getInfo/{id}")
    public Blog getInfo(@PathVariable("id") Integer id){
        Blog blog = blogService.getInfoById(id);
        return blog;
    }

}
