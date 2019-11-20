package com.mbyte.easy.publish.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author                   戴书博
 * @Description              出版社
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_publish")
public class Publish extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 出版社的名字
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
