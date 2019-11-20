package com.mbyte.easy.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName Middle
 * @Description
 * @Author 戴书博
 * @Date 2019/11/18 13:28
 * @Version 1.0
 **/
@Data
public class Middle {

    /**
     * 用户id
     */
    private Long studentId;

    /**
     * 图书的id
     */
    private Long bookId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
