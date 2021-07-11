package com.example.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.entity.Blog;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiong
 * @since 2021-07-11
 */
public interface IBlogService {

    Blog getInfoById(Integer id);
}
