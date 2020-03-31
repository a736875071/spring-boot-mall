package com.change.service.impl;

import com.change.config.exception.MsgException;
import com.change.dto.*;
import com.change.mapper.ums.UmsAdminRoleRelationMapper;
import com.change.mapper.ums.UmsRoleMenuRelationMapper;
import com.change.model.ums.UmsAdmin;
import com.change.model.ums.UmsAdminRoleRelation;
import com.change.model.ums.UmsRole;
import com.change.service.UmsAdminRoleService;
import com.change.service.UmsAdminService;
import com.change.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/23 10:34
 */
@Service
public class UmsAdminRoleServiceImpl implements UmsAdminRoleService {
    private final static int ERROR_CODE = 1001;
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private UmsRoleService umsRoleService;
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;
    @Autowired
    private UmsRoleMenuRelationMapper umsrolemenurelationmapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdminRole(UmsAdminRoleParam param) {
        //查询用户是否存在
        UmsAdmin umsAdmin = umsAdminService.selectByPrimaryKey(param.getAdminId());
        if (umsAdmin == null) {
            throw new MsgException(ERROR_CODE, "后台用户不存在");
        }
        Long adminId = umsAdmin.getId();
        if (param.getRoleIds().isEmpty()) {
            //删除全部权限
            umsAdminRoleRelationMapper.deleteAdminRoleRelationByAdminId(adminId);
        } else {
            //查询权限是否存在
            UmsRoleCondition condition = new UmsRoleCondition();
            condition.setIds(param.getRoleIds());
            List<UmsRole> roles = umsRoleService.getRoleList(condition);
            if (roles.isEmpty()) {
                throw new MsgException(ERROR_CODE, "添加角色不存在");
            } else if (param.getRoleIds().size() != roles.size()) {
                throw new MsgException(ERROR_CODE, "其中有" + (param.getRoleIds().size() - roles.size()) + "个角色不存在");
            }
            //删除全部权限
            umsAdminRoleRelationMapper.deleteAdminRoleRelationByAdminId(umsAdmin.getId());
            //重新添加用户权限
            List<UmsAdminRoleRelation> relations = new ArrayList<>();
            roles.forEach(role -> {
                UmsAdminRoleRelation relation = new UmsAdminRoleRelation();
                relation.setAdminId(adminId);
                relation.setRoleId(role.getId());
                relations.add(relation);
            });
            umsAdminRoleRelationMapper.addBatchAdminRoleRelation(relations);
        }

    }

    @Override
    public List<UmsAdminRoleRelation> findAdminRoleByAdminId(Long adminId) {
        return umsAdminRoleRelationMapper.findAdminRoleByAdminId(adminId);
    }

    @Override
    public AdminRoleMenuDto findRoleAndMenuByAdminId(Long adminId) {
        //查询用户角色
        List<RoleDto> roleDtos = umsAdminRoleRelationMapper.getRoleByAdminId(adminId);
        //查询角色对应的菜单
        List<UmsMenuDto> relations = umsrolemenurelationmapper.getRoleMenuByAdminId(adminId);

        return new AdminRoleMenuDto(roleDtos, relations);
    }

    @Override
    public AdminRoleMenuTreeDto findRoleAndMenuTreeByAdminId(Long adminId) {
        //查询用户角色
        List<RoleDto> roleDtos = umsAdminRoleRelationMapper.getRoleByAdminId(adminId);
        //查询角色对应的菜单
        List<UmsMenuDto> relations = umsrolemenurelationmapper.getRoleMenuByAdminId(adminId);

        return new AdminRoleMenuTreeDto(roleDtos, findTree(relations));
    }


    private List<UmsMenuDto> findTree(List<UmsMenuDto> allMenu) {
        try {//查询所有菜单
            //根节点
            List<UmsMenuDto> rootMenu = new ArrayList<>();
            for (UmsMenuDto nav : allMenu) {
                //父节点是0的，为根节点。
                if (nav.getParentId() == 0) {
                    rootMenu.add(nav);
                }
            }
            for (UmsMenuDto nav : rootMenu) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<UmsMenuDto> childList = getChild(nav.getId(), allMenu);
                //给根节点设置子节点
                nav.setChildren(childList);
            }
            return rootMenu;
        } catch (Exception e) {
            throw new MsgException(ERROR_CODE, "菜单查询异常");
        }
    }

    /**
     * 获取子节点
     *
     * @param id      父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    private List<UmsMenuDto> getChild(Long id, List<UmsMenuDto> allMenu) {
        //子菜单
        List<UmsMenuDto> childList = new ArrayList<>();
        for (UmsMenuDto nav : allMenu) {
            //相等说明：为该根节点的子节点。
            if (nav.getParentId().equals(id)) {
                childList.add(nav);
            }
        }
        //递归
        for (UmsMenuDto nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）
        if (childList.size() == 0) {
            return new ArrayList<>();
        }
        return childList;
    }
}
