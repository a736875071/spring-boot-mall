package com.change.service.impl;

import com.change.mapper.ums.UmsRoleMapper;
import com.change.model.ums.UmsRole;
import com.change.dto.UmsRoleCondition;
import com.change.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/20 13:38
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleMapper umsRoleMapper;

    @Override
    public List<UmsRole> getRoleList(UmsRoleCondition condition) {
        return umsRoleMapper.selectByExample(condition);
    }

    @Override
    public Boolean createRole(UmsRole umsRole) {
        UmsRoleCondition condition = new UmsRoleCondition();
        condition.setName(umsRole.getName());
        List<UmsRole> umsRoles = umsRoleMapper.selectByExample(condition);
        if (!umsRoles.isEmpty()) {
            throw new RuntimeException("角色名称已经存在");
        }
        return umsRoleMapper.insertSelective(umsRole) == 1;
    }

    @Override
    public Boolean updateRoleById(UmsRole umsRole) {
        UmsRole oldUmsRole = umsRoleMapper.selectByPrimaryKey(umsRole.getId());
        if (oldUmsRole == null) {
            throw new RuntimeException("角色名称不存在");
        }
        return umsRoleMapper.updateByPrimaryKeySelective(umsRole) == 1;
    }

    @Override
    public Boolean deleteRoleById(Long id) {
        UmsRole oldUmsRole = umsRoleMapper.selectByPrimaryKey(id);
        if (oldUmsRole == null) {
            throw new RuntimeException("角色名称不存在");
        }
        return umsRoleMapper.deleteByPrimaryKey(id) == 1;
    }
}
