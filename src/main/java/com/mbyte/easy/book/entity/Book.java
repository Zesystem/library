package com.mbyte.easy.book.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author                   戴书博
 * @Description              图书实体类
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_book")
public class Book extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 图书编号
     */
    private Integer bookNumber;

    /**
     * 图书名称
     */
    private String name;

    /**
     * 出版日期
     */
    private LocalDateTime publishDate;

    /**
     * 出版社
     */
    private Integer publishHome;

    /**
     * 出版社名字
     */
    @TableField(exist = false)
    private String publishName;

    /**
     * 存放位置
     */
    private Integer storageLocation;

    /**
     * 位置名字
     */
    @TableField(exist = false)
    private String storageName;

    /**
     * 图书总量
     */
    private Integer totalNumber;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;

    /**
     * 出版时间：开始日期
     */
    @TableField(exist = false)
    private LocalDateTime beginTime;

    /**
     * 出版时间：结束日期
     */
    @TableField(exist = false)
    private LocalDateTime endTime;


}
