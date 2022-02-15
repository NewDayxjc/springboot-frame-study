package com.bisci.common.realname.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.superEntity.BaseEntity;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author 作者
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_realname")
public class Realname extends BaseEntity {


    @TableId(value = "CARDINFO_ID", type = IdType.AUTO)
    private Integer cardinfoId;

    private String msisdn;

    private String imsi;

    private String iccid;

    /**
     * 0激活，2停机，4销户
     */
    private Integer status;

    private LocalDateTime created;

    private LocalDateTime modified;

    /**
     * 1已实名,2未实名
     */
    private Integer type;


}
