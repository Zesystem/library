package com.mbyte.easy.generator.service.impl;

import com.mbyte.easy.generator.entity.SysGenerator;
import com.mbyte.easy.generator.mapper.SysGeneratorMapper;
import com.mbyte.easy.generator.service.ISysGeneratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author                   戴书博
 * @Description              自动生成工具类业务实现类
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Service
public class SysGeneratorServiceImpl extends ServiceImpl<SysGeneratorMapper, SysGenerator> implements ISysGeneratorService {

    @Override
    public List<String> getTables() {
        return this.baseMapper.getTables();
    }
}
