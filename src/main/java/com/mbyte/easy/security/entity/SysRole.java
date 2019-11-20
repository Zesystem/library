package com.mbyte.easy.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.mbyte.easy.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;
/**
 * @Author                   戴书博
 * @Description
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRole extends BaseEntity {


    private Boolean available;

    private String description;

    private String name;
    @TableField(exist = false)
    private List<SysResource> resources;

    public List<SysResource> getResources() {
        return resources;
    }
}