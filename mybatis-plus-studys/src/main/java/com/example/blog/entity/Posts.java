package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiong
 * @since 2021-07-11
 */
@Getter
@Setter
@TableName(value = "posts")
public class Posts  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "posts_id")
    private Integer postsId;

    private String postSubject;

    private Integer blogId;

    @TableField(exist = false)
    private List<Comments> commentsList;


}
