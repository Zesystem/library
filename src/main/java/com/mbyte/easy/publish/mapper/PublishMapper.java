package com.mbyte.easy.publish.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.publish.entity.Publish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              出版社
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface PublishMapper extends BaseMapper<Publish> {

    /**
     * 显示列表
     */
    IPage<Publish> listPage(@Param("page") IPage<Publish> page,@Param("publish")Publish publish);

    /**
     * 根据id查询
     */
    Publish selectByPrimaryKey(@Param("id")Long id);

    /**
     * 添加出版社
     */
    int insertPublic(@Param("publish") Publish publish);

    /**
     * 编辑出版社
     */
    int updatePublicById(@Param("publish")Publish publish);

    /**
     * 删除单个
     */
    int deletePublicById(@Param("id")Long id);

    /**
     * 批量删除
     */
    int deletePublicAllByIds(@Param("ids")List<Long> ids);

}
