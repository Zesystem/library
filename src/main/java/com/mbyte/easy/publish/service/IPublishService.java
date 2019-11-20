package com.mbyte.easy.publish.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.publish.entity.Publish;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @Author                   戴书博
 * @Description              出版社
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface IPublishService extends IService<Publish> {

    /**
     * 显示列表
     */
    IPage<Publish> listPage(IPage<Publish> page,Publish publish);

    /**
     * 根据id查询
     */
    Publish selectByPrimaryKey(Long id);

    /**
     * 添加出版社
     */
    int insertPublic(Publish publish);

    /**
     * 编辑出版社
     */
    int updatePublicById(Publish publish);

    /**
     * 删除单个
     */
    int deletePublicById(Long id);

    /**
     * 批量删除
     */
    int deletePublicAllByIds(List<Long> ids);

}
