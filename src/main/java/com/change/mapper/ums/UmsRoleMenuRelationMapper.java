package com.change.mapper.ums;

import com.change.dto.UmsMenuDto;
import com.change.model.ums.UmsRoleMenuRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/31 13:59
 */
public interface UmsRoleMenuRelationMapper {
    /**
     * 新增角色菜单
     *
     * @param roleMenus 参数
     */
    void addBatchUmsRoleMenuRelation(@Param("roleMenus") List<UmsRoleMenuRelation> roleMenus);

    /**
     * 通过角色查询用户菜单
     *
     * @param roleId 角色id
     * @return 结果
     */
    List<UmsRoleMenuRelation> getMenuListByRoleId(Long roleId);

    /**
     * 通过角色id删除角色菜单关系
     *
     * @param roleId 角色id
     */
    void deleteUmsRoleMenuRelationByRoleId(Long roleId);

    /**
     * 通过用户id 查询对应的菜单
     *
     * @param adminId 用户id
     * @return 结果
     */
    List<UmsMenuDto> getRoleMenuByAdminId(Long adminId);
}
