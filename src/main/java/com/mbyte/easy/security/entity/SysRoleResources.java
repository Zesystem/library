package com.mbyte.easy.security.entity;
/**
 * @Author                   戴书博
 * @Description
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public class SysRoleResources {
    private Long sysRoleId;

    private Long resourcesId;

    public Long getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public Long getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Long resourcesId) {
        this.resourcesId = resourcesId;
    }
}