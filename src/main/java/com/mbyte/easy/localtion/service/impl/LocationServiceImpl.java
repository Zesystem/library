package com.mbyte.easy.localtion.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mbyte.easy.localtion.entity.Location;
import com.mbyte.easy.localtion.mapper.LocationMapper;
import com.mbyte.easy.localtion.service.ILocationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author                   戴书博
 * @Description              位置
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationMapper, Location> implements ILocationService {
    /**
     * 显示列表
     */
    public IPage<Location> listPage(IPage<Location> page){
        return this.baseMapper.listPage(page);
    }

    /**
     * 根据id查询
     */
    public Location selectByPrimaryKey(Long id){
        return this.baseMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加出版社
     */
    public int insertLocation(Location location){
        location.setCreateTime(LocalDateTime.now());
        location.setUpdateTime(LocalDateTime.now());
        return this.baseMapper.insertLocation(location);
    }

    /**
     * 编辑出版社
     */
    public int updateLocationById(Location location){
        location.setUpdateTime(LocalDateTime.now());
        return this.baseMapper.updateLocationById(location);

    }

    /**
     * 删除单个
     */
    public int deleteLocationById(Long id){
        return this.baseMapper.deleteLocationById(id);

    }

    /**
     * 批量删除
     */
    public int deleteLocationAllByIds(List<Long> ids){
        return this.baseMapper.deleteLocationAllByIds(ids);
    }
}
