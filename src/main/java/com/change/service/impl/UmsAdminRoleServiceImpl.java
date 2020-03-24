package com.change.service.impl;

import com.change.config.exception.MsgException;
import com.change.dto.UmsAdminRoleParam;
import com.change.mapper.ums.UmsAdminRoleRelationMapper;
import com.change.model.ums.UmsAdmin;
import com.change.model.ums.UmsAdminRoleRelation;
import com.change.model.ums.UmsRole;
import com.change.model.ums.UmsRoleCondition;
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
    private static int ERROR_CODE = 1001;
    @Autowired
    private UmsAdminService umsAdminService;
    @Autowired
    private UmsRoleService umsRoleService;
    @Autowired
    private UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

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
}
