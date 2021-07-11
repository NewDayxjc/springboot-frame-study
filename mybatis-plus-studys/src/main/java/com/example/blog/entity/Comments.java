package com.example.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
@TableName(value = "comments")
public class Comments {

    private static final long serialVersionUID = 1L;
    @TableId(value = "comments_id")
    private Integer commentsId;
    @TableField(value = "commentContent")

    private String commentContent;

    private Integer postsId;


}
