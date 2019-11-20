package com.mbyte.easy.security.entity;
/**
 * @Author                   戴书博
 * @Description
 * @Date                     2019/11/11
 * @Version                  1.0
 */
public class SysUserRoles {
    private Long sysUserId;

    private Long rolesId;

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getRolesId() {
        return rolesId;
    }

    public void setRolesId(Long rolesId) {
        this.rolesId = rolesId;
    }
}