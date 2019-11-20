package com.mbyte.easy.localtion.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.localtion.entity.Location;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author                   戴书博
 * @Description              位置
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface ILocationService extends IService<Location> {
    /**
     * 显示列表
     */
    IPage<Location> listPage(IPage<Location> page);

    /**
     * 根据id查询
     */
    Location selectByPrimaryKey(Long id);

    /**
     * 添加出版社
     */
    int insertLocation(Location location);

    /**
     * 编辑出版社
     */
    int updateLocationById(Location location);

    /**
     * 删除单个
     */
    int deleteLocationById(Long id);

    /**
     * 批量删除
     */
    int deleteLocationAllByIds(List<Long> ids);
}
