package com.change.service;

import com.change.dto.UmsAdminRoleParam;
import com.change.model.ums.UmsAdminRoleRelation;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/23 10:30
 */
public interface UmsAdminRoleService {
    /**
     * 更新后台用户权限
     *
     * @param param 参数
     */
    void updateAdminRole(UmsAdminRoleParam param);

    /**
     * 通过用户查询用户关联角色信息
     *
     * @param adminId
     * @return 结果
     */
    List<UmsAdminRoleRelation> findAdminRoleByAdminId(Long adminId);
}
