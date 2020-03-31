package com.change.service;

import com.change.dto.AdminRoleMenuDto;
import com.change.dto.AdminRoleMenuTreeDto;
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

    /**
     * 查询用户的角色及资源
     *
     * @param adminId 用户id
     * @return 结果
     */
    AdminRoleMenuDto findRoleAndMenuByAdminId(Long adminId);

    /**
     * 查询用户的角色及资源(菜单树形结构)
     *
     * @param adminId 用户id
     * @return 结果
     */
    AdminRoleMenuTreeDto findRoleAndMenuTreeByAdminId(Long adminId);
}
