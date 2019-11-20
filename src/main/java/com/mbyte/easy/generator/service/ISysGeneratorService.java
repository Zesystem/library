package com.mbyte.easy.generator.service;

import com.mbyte.easy.generator.entity.SysGenerator;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              自动生成工具类业务接口
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface ISysGeneratorService extends IService<SysGenerator> {

    /**
     * @Author 王震
     * @Description 查询全部的数据库表
     * @Date 11:21 2019/4/16
     * @return java.util.List<java.lang.String>
     **/
    List<String> getTables();

}
