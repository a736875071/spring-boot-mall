package com.change.service;

import com.change.dto.UmsRoleMenuParam;
import com.change.model.ums.UmsRoleMenuRelation;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/23 10:30
 */
public interface UmsRoleMenuService {
    /**
     * 更新角色菜单
     *
     * @param param 参数
     */
    void updateMenuByRoleId(UmsRoleMenuParam param);

    /**
     * 通过角色查询用户菜单
     *
     * @param roleId
     * @return 结果
     */
    List<UmsRoleMenuRelation> getMenuListByRoleId(Long roleId);
}
