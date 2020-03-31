package com.change.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author YangQ
 * @date 2020/3/31 15:05
 */
@Data
@AllArgsConstructor
public class AdminRoleMenuTreeDto {
    private List<RoleDto> roleDtos;
    private List<UmsMenuDto> umsMenuTree;
}
