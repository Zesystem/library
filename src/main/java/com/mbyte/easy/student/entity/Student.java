package com.mbyte.easy.student.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mbyte.easy.common.entity.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author                   戴书博
 * @Description              学生
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_student")
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学生姓名
     */
    private String name;

    /**
     * 院系
     */
    private String department;

    /**
     * 所学专业
     */
    private String professtion;

    /**
     * 借书证号
     */
    private String certificateNumber;

    /**
     * 最大借书数
     */
    private Integer maxBookNum;

    /**
     * 欠费情况
     */
    private Integer arrearsNum;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
