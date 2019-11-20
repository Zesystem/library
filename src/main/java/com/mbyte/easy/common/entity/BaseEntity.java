package com.mbyte.easy.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Author                   戴书博
 * @Description              基础Entity
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Data
public class BaseEntity {
    /**
     * 主键id,数据库中必须有id字段,且id字段为主键自增的bigint类型
     * @TableId 指定该属性为自增类型
     */
    @TableId(type = IdType.AUTO,value = "id")
    private long id;
}