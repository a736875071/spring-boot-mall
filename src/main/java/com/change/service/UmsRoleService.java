package com.change.service;

import com.change.model.ums.UmsRole;
import com.change.model.ums.UmsRoleCondition;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/20 11:54
 */
public interface UmsRoleService {

    /**
     * 查询角色列表
     *
     * @param condition
     * @return 结果
     */
    List<UmsRole> getRoleList(UmsRoleCondition condition);

    /**
     * 创建角色
     *
     * @param umsRole
     * @return
     */
    Boolean createRole(UmsRole umsRole);

    /**
     * 修改角色
     *
     * @param umsRole
     * @return
     */
    Boolean updateRoleById(UmsRole umsRole);

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    Boolean deleteRoleById(Long id);
}
