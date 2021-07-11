package com.example.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.entity.Blog;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiong
 * @since 2021-07-11
 */

public interface BlogMapper extends BaseMapper<Blog> {

    Blog getInfoById(Integer id);
}
