package com.change.service.impl;

import com.change.config.exception.MsgException;
import com.change.dto.UmsMenuCondition;
import com.change.dto.UmsRoleMenuParam;
import com.change.mapper.ums.UmsMenuMapper;
import com.change.mapper.ums.UmsRoleMapper;
import com.change.mapper.ums.UmsRoleMenuRelationMapper;
import com.change.model.ums.UmsMenu;
import com.change.model.ums.UmsRole;
import com.change.model.ums.UmsRoleMenuRelation;
import com.change.service.UmsRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YangQ
 * @date 2020/3/31 13:55
 */
@Service
public class UmsRoleMenuServiceImpl implements UmsRoleMenuService {
    private final static int ERROR_CODE = 193;
    @Autowired
    private UmsRoleMenuRelationMapper umsRoleMenuRelationMapper;
    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Autowired
    private UmsMenuMapper umsMenuMapper;

    @Override
    public void updateMenuByRoleId(UmsRoleMenuParam param) {
        //查询角色是否存在
        UmsRole umsRole = umsRoleMapper.selectByPrimaryKey(param.getRoleId());
        if (umsRole == null) {
            throw new MsgException(ERROR_CODE, "角色不存在");
        }
        Long roleId = umsRole.getId();
        if (param.getMenuIds().isEmpty()) {
            //删除该角色所有菜单
            umsRoleMenuRelationMapper.deleteUmsRoleMenuRelationByRoleId(roleId);
            return;
        }
        //查询菜单是否存
        UmsMenuCondition condition = new UmsMenuCondition();
        condition.setIds(param.getMenuIds());
        List<UmsMenu> umsMenus = umsMenuMapper.getUmsMenuList(condition);
        if (umsMenus.isEmpty()) {
            throw new MsgException(ERROR_CODE, "菜单不存在");
        } else if (umsMenus.size() != param.getMenuIds().size()) {
            throw new MsgException(ERROR_CODE, "共有" + (umsMenus.size() - param.getMenuIds().size()) + "个菜单不存在");
        }
        //编辑角色菜单
        umsRoleMenuRelationMapper.deleteUmsRoleMenuRelationByRoleId(param.getRoleId());
        List<UmsRoleMenuRelation> relations = umsMenus.stream().map(relation -> {
            UmsRoleMenuRelation umsRoleMenuRelation = new UmsRoleMenuRelation();
            umsRoleMenuRelation.setMenuId(relation.getId());
            umsRoleMenuRelation.setRoleId(roleId);
            return umsRoleMenuRelation;
        }).collect(Collectors.toList());
        umsRoleMenuRelationMapper.addBatchUmsRoleMenuRelation(relations);
    }

    @Override
    public List<UmsRoleMenuRelation> getMenuListByRoleId(Long roleId) {
        return umsRoleMenuRelationMapper.getMenuListByRoleId(roleId);
    }
}
