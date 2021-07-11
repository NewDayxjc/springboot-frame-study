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
@TableName(value = "Blog")
public class Blog  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Integer id;

    private String title;

    @TableField(exist = false)
    private List<Posts> postsList;
    @TableField(exist = false)
    private List<Comments> commentsList;


}
