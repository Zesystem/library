package com.mbyte.easy.publish.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mbyte.easy.publish.entity.Publish;
import com.mbyte.easy.publish.mapper.PublishMapper;
import com.mbyte.easy.publish.service.IPublishService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author                   戴书博
 * @Description              出版社
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Transactional
@Slf4j
@Service
public class PublishServiceImpl extends ServiceImpl<PublishMapper, Publish> implements IPublishService {

    /**
     * 显示列表
     */
    public IPage<Publish> listPage(IPage<Publish> page,Publish publish){
        return this.baseMapper.listPage(page,publish);
    }

    /**
     * 根据id查询
     */
    public Publish selectByPrimaryKey(Long id){
        return this.baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加出版社
     */
    public int insertPublic(Publish publish){
        publish.setCreateTime(LocalDateTime.now());
        publish.setUpdateTime(LocalDateTime.now());
        return this.baseMapper.insertPublic(publish);
    }

    /**
     * 编辑出版社
     */
    public int updatePublicById(Publish publish){
        publish.setUpdateTime(LocalDateTime.now());
        return this.baseMapper.updatePublicById(publish);

    }

    /**
     * 删除单个
     */
    public int deletePublicById(Long id){
        return this.baseMapper.deletePublicById(id);

    }

    /**
     * 批量删除
     */
    public int deletePublicAllByIds(List<Long> ids){
        return this.baseMapper.deletePublicAllByIds(ids);
    }
}
