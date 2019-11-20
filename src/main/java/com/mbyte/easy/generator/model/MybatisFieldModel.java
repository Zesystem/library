package com.mbyte.easy.generator.model;

import lombok.*;

/**
 * @Author                   戴书博
 * @Description              封装mybatis参数
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class MybatisFieldModel {
    private String column;
    private String jdbcType;
    private String property;
    private boolean keyFlag;


}
