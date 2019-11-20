package com.mbyte.easy.generator.entity;

import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author                   戴书博
 * @Description              代码生成工具实体
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysGenerator extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 模块名称
     */
    @TableField("moduleName")
    private String moduleName;

    /**
     * 表名称
     */
    @TableField("tableName")
    private String tableName;

    /**
     * 是否忽略前缀1：是
     */
    @TableField("ignoreFlag")
    private Integer ignoreFlag;

    /**
     * 前缀
     */
    @TableField("ignorePrefix")
    private String ignorePrefix;

    /**
     * 是否生成rest接口1:是
     */
    @TableField("createRest")
    private Integer createRest;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;


}
