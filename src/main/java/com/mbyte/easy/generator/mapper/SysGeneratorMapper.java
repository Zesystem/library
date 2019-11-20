package com.mbyte.easy.generator.mapper;

import com.mbyte.easy.generator.entity.SysGenerator;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              代码生成工具dao
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface SysGeneratorMapper extends BaseMapper<SysGenerator> {

    /**
     * @Author 戴书博
     * @Description 获取全部的数据库表
     * @Date 11:40 2019/11/11
     * @return 数据库表
     **/
    @Select("show tables")
    List<String> getTables();
}
