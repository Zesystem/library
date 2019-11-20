package com.mbyte.easy.security.mapper;

import com.mbyte.easy.security.entity.SysOrganization;
/**
 * @Author                   戴书博
 * @Description
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public interface SysOrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    SysOrganization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);
}