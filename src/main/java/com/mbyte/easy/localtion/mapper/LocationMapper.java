package com.mbyte.easy.localtion.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.localtion.entity.Location;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mbyte.easy.publish.entity.Publish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              位置
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface LocationMapper extends BaseMapper<Location> {

    /**
     * 显示列表
     */
    IPage<Location> listPage(@Param("page") IPage<Location> page);

    /**
     * 根据id查询
     */
    Location selectByPrimaryKey(@Param("id")Long id);

    /**
     * 添加出版社
     */
    int insertLocation(@Param("location") Location location);

    /**
     * 编辑出版社
     */
    int updateLocationById(@Param("location")Location location);

    /**
     * 删除单个
     */
    int deleteLocationById(@Param("id")Long id);

    /**
     * 批量删除
     */
    int deleteLocationAllByIds(@Param("ids") List<Long> ids);

}
