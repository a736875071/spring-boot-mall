package com.change.dto;

import com.change.model.ums.UmsMenu;
import com.change.model.ums.UmsRoleMenuRelation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/31 15:05
 */
@Data
@AllArgsConstructor
public class AdminRoleMenuDto {
    private List<RoleDto> roleDtos;
    private List<UmsMenuDto> umsMenus;
}
